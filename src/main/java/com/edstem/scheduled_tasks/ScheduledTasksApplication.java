package com.edstem.scheduled_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScheduledTasksApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScheduledTasksApplication.class, args);
	}
}
