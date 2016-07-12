package com.inventory.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	private static final Logger logger = Logger.getLogger(DashboardController.class);
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session){
		
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
