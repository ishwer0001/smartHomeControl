package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.SystemControlService;

@Component
public class ScheduledJob {

	@Autowired
	SystemControlService service;


    @Scheduled(cron = "0 1 1 1 *") // Runs every 5 seconds
    public void runJob() throws Exception {
    	service.updateAirConditioner(false);
    	service.updateLight(false);
    	service.updateFanSpeed(0);
    }
}