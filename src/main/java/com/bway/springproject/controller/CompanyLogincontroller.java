package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.Company;
import com.bway.springproject.repository.CompanyRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyLogincontroller {
	
	@Autowired
	public CompanyRepository companyRepo;
	
	@GetMapping("/companylogin")
	public String getLogin() {
		
		return "CompanyLogin";
	}
	
	
	@PostMapping("/companylogin")
	public String postLogin(@ModelAttribute Company c, Model model, HttpSession session ) {
		
		Company cy = companyRepo.findByEmailAndPassword(c.getEmail(), c.getPassword());
		
		 if (c.getEmail() == null && c.getPassword() == null || c.getEmail().isEmpty() && c.getPassword().isEmpty()) {
		        model.addAttribute("message", "Email and Password cannot be empty!");
		        return "CompanyLogin";
		    }
		 
		 if (c.getEmail() == null || c.getEmail().isEmpty()) {
		        model.addAttribute("message", "Email cannot be empty!");
		        return "CompanyLogin";
		    }
		 
		        if ( c.getPassword() == null  || c.getPassword().isEmpty()) {
			        model.addAttribute("message", "Password cannot be empty!");
			        return "CompanyLogin";
		    }
		
		    Company companyByEmail = companyRepo.findByEmail(c.getEmail());
		    if (companyByEmail == null) {
		        model.addAttribute("message", "Email not found!");
		        return "CompanyLogin";
		    }
		    
		    Company companyByPassword = companyRepo.findByPassword(c.getPassword());
		    if (companyByPassword == null) {
		        model.addAttribute("message", "Please enter the correct password!");
		        return "CompanyLogin";
		    }

		    
	if(cy !=null) {
		
		session.setAttribute("activeuser",cy);
		session.setMaxInactiveInterval(300);
			
			//model.addAttribute("cemail",c.getEmail());
			return "homecompany";
	}

		model.addAttribute("message","Email not found!!");
		return "CompanyLogin";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		
		session.invalidate();
		return "CompanyLogin";
	}
	@GetMapping("/cprofile")
	public String getProfile() {
		
		return "CompanyProfile";
	}
	
}
