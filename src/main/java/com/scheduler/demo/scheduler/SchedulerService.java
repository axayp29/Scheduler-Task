package com.scheduler.demo.scheduler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.scheduler.demo.model.Doctor;
import com.scheduler.demo.model.repo.DoctorRepo;

@Service
public class SchedulerService {

    public final DoctorRepo taskRepository;
    
    private final ThreadPoolTaskScheduler taskScheduler;
    
    private Map<String, ScheduledFuture<?>> scheduledFutures = new ConcurrentHashMap<>();
    
   

    public SchedulerService(DoctorRepo taskRepository,ThreadPoolTaskScheduler taskScheduler) {
        this.taskRepository = taskRepository;
        this.taskScheduler = taskScheduler;
       
        
    }
    
 
    @Scheduled(fixedRate = 60000) // Check the database every minute (adjust as needed)
    public void scheduleTasksFromDatabase() {
        List<Doctor> tasks = taskRepository.findAll();
       
        for (Doctor task : tasks) {
        	
            scheduleTask(task);
        }
        
    }

    private void scheduleTask(Doctor task) {
        try {
        	
        	 // Get the existing ScheduledFuture for the task
            ScheduledFuture<?> existingScheduledFuture = scheduledFutures.get(task.getName());

            // If an existing task is already scheduled, cancel it
            if (existingScheduledFuture != null) {
                existingScheduledFuture.cancel(true);
            }
           
            CronTrigger cronTrigger = new CronTrigger(task.getCronFunction());

            YourTaskClass taskInstance = new YourTaskClass(task);

            // Schedule the task with the Spring scheduler
           
            ScheduledFuture<?> scheduledFuture= taskScheduler.schedule(taskInstance, cronTrigger);
            
            scheduledFutures.put(task.getName(), scheduledFuture);
           
        } catch (IllegalArgumentException e) {
           
            System.err.println("Invalid cron expression for task: " + task.getName());
        }
    }
    
 
}