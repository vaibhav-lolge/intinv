package com.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.model.ReturnMessage;
import com.inventory.model.Roles;
import com.inventory.model.User;
import com.inventory.service.CustomerService;
import com.inventory.service.ICustomerService;

@Controller
public class RegisterController {
	
	private static final Logger logger = Logger.getLogger(InventoryWelcome.class);
	private static int active = 0; //default deactivated account.
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showLoginForm(HttpSession session, Model model){
		logger.debug("---INFO---: REGISTER PAGE");
		if(session.getAttribute("loggedInUser")==null){
			
			ICustomerService customerService = new CustomerService();
			List <Roles> rolesList = customerService.getRoles();
			model.addAttribute("user_roles", rolesList);
			return "register";
		}
		else{
			return "redirect:/";
		}	
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String name, 
			@RequestParam String password, @RequestParam String identifier, @RequestParam String role,  HttpSession session, Model model){
		
		ICustomerService customerService = new CustomerService();
		List <Roles> rolesList = customerService.getRoles();
		model.addAttribute("user_roles", rolesList);
		User user = new User();
		user.setActive(active);
		user.setIdentifier(identifier);
		user.setRole(Integer.parseInt(role));
		user.setPassword(password);
		user.setName(name);
		ReturnMessage returnMsg = customerService.registerUser(user);
		if (returnMsg.isSuccess()){
			logger.debug("---INFO---: User registered: " + name);
			model.addAttribute("registerSuccessful", returnMsg.getMessage());
			return "login";
		}else{
			model.addAttribute("registerError", returnMsg.getMessage());
			return "register";
		}
		
	}

}
