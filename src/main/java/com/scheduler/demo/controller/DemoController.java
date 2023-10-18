package com.scheduler.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.demo.scheduler.SchedulerService;

@RestController
public class DemoController {
	
	@Autowired 
	public SchedulerService schedulerService;

	
	@RequestMapping(value = "/demo1")
	public String demo1() 
	{
		schedulerService.scheduleTasksFromDatabase();
		return "SUCCESS";
	}
	
	

}