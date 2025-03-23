package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Publish;
import com.bway.springproject.service.PublishService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PublishController {
	
	@Autowired
	private PublishService publService;
	
	@GetMapping("/publish")
	public String getPublish() {
		
		return "Publish";
	}

	@PostMapping("/publish")
	public String postPublish(@ModelAttribute Publish publ, Model model) {
		
		publService.addPubl(publ);
		
		return "Publish";
	}
	
	@GetMapping("/publishlist")
	public String getAllToCompany(Model model, HttpSession session) {
		
		if (session.getAttribute("activeuser") ==null) {
			return "CompanyLogin";
		}
		model.addAttribute("pList",publService.getAllPubls());
		return "PublishList";
	}
	
	
	@GetMapping("/publ/delete")
	public String delete(@RequestParam int id) {
		
		publService.deletePubl(id);
		
		return "redirect:/publishlist";
	}
	
	
	@GetMapping("/publ/edit")
	public String edit(@RequestParam int id, Model model) {
		
		model.addAttribute("pModel",publService.getPublById(id));
		
		return "PublishEdit";
	}
	
	@PostMapping("/publ/update")
	public String update(@ModelAttribute Publish publ) {
		
		publService.updatePubl(publ);
		return "redirect:/publishlist";
	}
}