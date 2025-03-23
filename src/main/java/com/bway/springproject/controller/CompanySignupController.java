package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.Company;
import com.bway.springproject.repository.CompanyRepository;

@Controller
public class CompanySignupController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@GetMapping("/companysignup")
	public String getSignup() {
		
		return "CompanySignup";
	}
	
	@PostMapping("/companysignup")
	public String postSignup(@ModelAttribute Company company) {
		
		companyRepo.save(company);
		
		return "CompanyLogin";
	}

}
