
package com.bway.springproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Job;
import com.bway.springproject.repository.JobRepository;
import com.bway.springproject.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository JoobRepo;
	@Override
	public void addjob(Job jb) {
		JoobRepo.save(jb);
		
	}

	@Override
	public Job getjobById(int id) {
		
		return JoobRepo.findById(id).get();
	}

	@Override
	public List<Job> getAllJobs() {
		
		return JoobRepo.findAll();
	}

	
}