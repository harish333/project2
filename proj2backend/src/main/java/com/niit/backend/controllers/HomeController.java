package com.niit.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String getLanding()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String getHome()
	{
		return "home";
	}
}
