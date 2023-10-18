package com.scheduler.demo.scheduler;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;

import com.scheduler.demo.model.Doctor;


@ComponentScan
public class YourTaskClass implements Runnable {
	
	public  Doctor task;
	
    public YourTaskClass(Doctor task) {
		super();
		this.task = task;
	}

	// Implement the logic for your scheduled task here
    @Override
    public void run() {
     	switch (task.getName()) {
			case "Leave Application" -> System.err.println("Every 10 Second : "+task.getName() +" : "+new Date().getSeconds() );
			case "Loan Application" -> System.err.println("Every 12 Second : "+task.getName() +" : "+new Date().getSeconds());
			case "Advance Application"-> System.err.println("Every 5 Second : "+task.getName() +" : "+new Date().getSeconds());
			case "OD Application"-> System.err.println("Every 7 Second : "+task.getName() +" : "+new Date().getSeconds());
			default->
				throw new IllegalArgumentException("Unexpected value: " + task.getName());
			
    	}
    	
    }
}