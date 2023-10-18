package com.scheduler.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedularTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedularTaskApplication.class, args);
	}

}
