package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.Seekers;
import com.bway.springproject.repository.SeekersRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SeekerController {

	@Autowired
	private SeekersRepository seekersRepo;

	@GetMapping("/seekerslogin")
	public String getlogin() {

		return "SeekersLogin";
	}

	@PostMapping("/seekerslogin")
	public String postLogin(@ModelAttribute Seekers s, Model model, HttpSession session) {

		Seekers sks = seekersRepo.findByUsernameAndPassword(s.getUsername(), s.getPassword());
		
		if (s.getUsername() == null && s.getPassword() == null|| s.getUsername().isEmpty() &&  s.getPassword().isEmpty()) {
		    model.addAttribute("message", "Username and password cannot be empty!");
		    return "SeekersLogin";
		
		}

		if (s.getUsername() == null || s.getUsername().isEmpty()) {
			model.addAttribute("message", "Enter your username!!");
			return "SeekersLogin";
		}

		if (s.getPassword() == null || s.getPassword().isEmpty()) {
			model.addAttribute("message", "Enter your password!!");
			return "SeekersLogin";
		}

		Seekers seekersByUsername = seekersRepo.findByUsername(s.getUsername());
		if (seekersByUsername == null) {
			model.addAttribute("message", "Please enter the correct username!!");
			return "SeekersLogin";
		}

		Seekers seekersByPassword = seekersRepo.findByPassword(s.getPassword());
		if (seekersByPassword == null) {
		model.addAttribute("message", "Please enter the correct password!!");	
			return "SeekersLogin";
		}

		if (sks != null) {
			
			session.setAttribute("activeseekers",sks);
			session.setMaxInactiveInterval(300);
			
			//model.addAttribute("sname", s.getUsername());
			return "Home";
		}
		
		model.addAttribute("message","Username not found!!");
		return "SeekersLogin";
	}

	@GetMapping("/sprofile")
	public String getProfile() {
		return "Profile";
	}
	
	@GetMapping("/logouts")
	public String getLogout(HttpSession session) {
		
		session.invalidate();
		
		return "SeekersLogin";
	}
	
}
