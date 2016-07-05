package com.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inventory.model.Roles;
import com.inventory.model.User;
import com.inventory.service.CustomerService;
import com.inventory.service.ICustomerService;


@Controller
public class UserControlController {

	private static final Logger logger = Logger.getLogger(InventoryWelcome.class);
	ICustomerService customerService = new CustomerService();
	
	@RequestMapping("/userControl")
	public String userControl(HttpSession session, Model model){
		logger.debug("----INFO----: User Control Page.");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			logger.debug("----INFO----: LOGGED IN USER: " + session.getAttribute("loggedInUser"));		
			Roles role = customerService.getRole(session.getAttribute("loggedInUser").toString());
			if(role.getId()!=1){
				model.addAttribute("authorizationError", "You are not authorized to view the page. Please contact admin.");
				return "welcome";				
			}else{
				List<User> userList = customerService.getUserList();
				model.addAttribute("userList",userList);
				return "userControl";
			}
			
		}
	}
	
	@RequestMapping(value="/userControl", method=RequestMethod.POST)
	public String activateDeactivateUser(HttpSession session, Model model, HttpServletRequest request){
		logger.debug("----INFO----: User Control Page.");
		String userIdentifier = request.getParameter("deactivate");
		System.out.println(">>>>>>>>>>>>>>>: "+userIdentifier);
		return "userControl";
	}
	
}
