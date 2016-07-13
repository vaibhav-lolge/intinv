package com.inventory.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryWelcome {
	
	private static final Logger logger = Logger.getLogger(InventoryWelcome.class);
	
	
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session, Model model){
		
		logger.debug("----INFO----: HOME PAGE.");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			logger.debug("----INFO----: LOGGED IN USER: " + session.getAttribute("loggedInUser"));
			return "welcome";
		}
	}
	
	

}
