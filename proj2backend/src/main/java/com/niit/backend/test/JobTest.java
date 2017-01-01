package com.niit.backend.test;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Job;



public class JobTest {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		JobDao jobDao = (JobDao)context.getBean("jobDao"); 
		Job job = (Job)context.getBean("job");
		//job.setJobId(1);
		job.setJobTitle("testing");
		job.setJobDescription("tester");
		job.setPostedOn(new Date());
		job.setSkillsRequired("c#");
		job.setSalary("23k");
		job.setLocation("hyderabad");
		
		jobDao.postJob(job);
		
}}