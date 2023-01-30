package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.model.PoliticianProfile;

@Controller
public class PoliticianOperationsController {

	@GetMapping("/")
	public String showHome() {
		System.out.println("PoliticianOperationsController.showHome()");
		
		//return lvn
		return "hh";
	}
	
	//@PostMapping("/register")
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String showFormPage(@ModelAttribute("pp") PoliticianProfile profile) {
		System.out.println("PoliticianOperationsController.showFormPage()");
		System.out.println("Model class obj data::" +profile);
		//by invoking service class u can execute a b.logic
		
		
		//return lvn
		return "politician_register";
	}
}
