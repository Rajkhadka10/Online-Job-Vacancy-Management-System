package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.Seekers;
import com.bway.springproject.repository.SeekersRepository;

@Controller
public class SeekersSignupController {
	
	@Autowired
	private SeekersRepository seekersRepo;
	
	@GetMapping("/seekersSignup")
	
	public String getSignup() {
		
		return "SeekersSignup";
	}
	
	@PostMapping("/seekersSignup")
	
	public String postSignup(@ModelAttribute Seekers seekers, Model model) {
		
		seekersRepo.save(seekers);
	
		return "SeekersLogin";
	}
	
	/*
	 * -------how to connect database in spring boot---
	 * 1> Spring Data JPA
	 * 2> Mysql Driver
	 */

}
