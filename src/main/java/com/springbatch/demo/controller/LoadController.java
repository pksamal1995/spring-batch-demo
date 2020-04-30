package com.springbatch.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping("/users")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		System.out.println("-----------------------------------------------------------------");
		Map<String, JobParameter> parameters = new HashMap<>();
		
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(parameters);

		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		
		System.out.println("Batch is Running.....");
		while (jobExecution.isRunning()) {
			System.out.println("....");
		}
		
		return jobExecution.getStatus();
	}
}
