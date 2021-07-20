package com.adfsauth.adfsauth.presentation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping(value = "")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/auth")
	public String handleSamlAuth() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());

		
		// créer un jeu d'allé retour (why not!)
		
		return "forward:/home";
	}
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("username", authentication.getPrincipal());
		return "home";
	}

}
