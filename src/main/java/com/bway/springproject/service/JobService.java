package com.bway.springproject.service;

import java.util.List;

import com.bway.springproject.model.Job;

public interface JobService {

	void addjob(Job jb);

	Job getjobById(int id);

	List<Job> getAllJobs();
}
