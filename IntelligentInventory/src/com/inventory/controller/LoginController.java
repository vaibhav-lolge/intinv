package com.inventory.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.model.User;
import com.inventory.service.CustomerService;
import com.inventory.service.ICustomerService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(InventoryWelcome.class);
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginForm(HttpSession session, Model model){
		logger.debug("---INFO---: LOGIN PAGE");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			return "welcome";
		}		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, 
			@RequestParam String password, HttpSession session, Model model){
		logger.debug("---INFO---: VERIFY LOGIN");
		ICustomerService customerService = new CustomerService();
		User user = customerService.logiCustomer(userId, password);
		
		if(user!=null){
			
			if (user.getActive()==0){
				logger.debug("---INFO---: LOGIN UNSUCCESSFUL. ACCOUNT NOT ACTIVE.");
				model.addAttribute("loginError", "Your account is not active yet! Please contact the admin.");
				return "login";			
			}else{
			logger.debug("---INFO---: LOGIN SUCCESSFUL");
			session.setAttribute("loggedInUser", userId);
			return "welcome";
			}
		}else{
			logger.debug("---INFO---: LOGIN UNSUCCESSFUL");
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "login";
		}
	}
	
	@RequestMapping(value= "/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("loggedInUser");
		return "redirect:/";
	}
	
}
