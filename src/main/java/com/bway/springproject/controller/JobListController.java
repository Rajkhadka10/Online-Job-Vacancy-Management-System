package com.bway.springproject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Job;
import com.bway.springproject.service.JobService;
import com.bway.springproject.service.PublishService;

import jakarta.servlet.http.HttpSession;

@Controller
	public class JobListController {
 
	@Autowired
	private JobService jobService;
	    @Autowired
	    private PublishService publService;

	    @GetMapping("/joblist")
	    public String getPublishList(Model model, HttpSession session) {
	    	
	    	if (session.getAttribute("activeseekers") ==null) {
				return "SeekersLogin";
			}
	        model.addAttribute("pList", publService.getAllPubls());
	        
	        return "JobList";
	    }
	    
	    @GetMapping("/job/apply")
		public String Apply( @RequestParam String title , Model model) {
			
	    	
			model.addAttribute("jobtitle" ,title);
			
			return "Apply";
		}
		
		@PostMapping("/job/apply")
		public String PostApply(@ModelAttribute Job jb) {
			
			jobService.addjob(jb);
			
			return "Success";
		}
			
			@GetMapping("/applicant")
			public String getApplicantList(Model model, HttpSession session) {
				
				if (session.getAttribute("activeuser") ==null) {
					return "CompanyLogin";
				}
				model.addAttribute("aList", jobService.getAllJobs());
				return "Applicantlist";
			}
			
			@GetMapping("/accept")
			public String Accept(@RequestParam String email, String jobtitle, Model model) {
				
				model.addAttribute("jobemail", email);
				model.addAttribute("title", jobtitle);
				
				return "ContactForm";
			}
			
			@GetMapping("/reject")
			public String Reject(@RequestParam String email, String jobtitle, Model model) {
				
				model.addAttribute("jobemail", email);
				model.addAttribute("title", jobtitle);
				return "ContactForm";
			}
		
	}