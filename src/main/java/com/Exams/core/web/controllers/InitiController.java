package com.Exams.core.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InitiController {
	@RequestMapping("/")
	public String index(Model model) {

		return "loginForm";
	}
}
