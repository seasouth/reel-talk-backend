package com.reel.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainContoller {

	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
