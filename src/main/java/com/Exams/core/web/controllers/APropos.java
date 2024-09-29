package com.Exams.core.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APropos {


	@RequestMapping("aPropos")
	public String apropos() {
    	return  "apropos/apropos" ; 
    	}
}