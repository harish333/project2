package com.niit.backend.dao;


import java.util.List;

import com.niit.backend.model.Job;



public interface JobDao 
{
	public void addJob( Job job);
	void postJob(Job job);
	List<Job> getAllJobs();
	public Job registerJob(Job job);
}

