package com.inventory.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;
import com.inventory.service.IInventoryService;
import com.inventory.service.InventoryService;

@Controller
public class InventoryController {
private static final Logger logger = Logger.getLogger(InventoryController.class);
private static int active = 1; //default deactivated account.
	
	@RequestMapping("/categories")
	public String categories(HttpSession session){
		
		logger.debug("----INFO----: HOME PAGE.");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			logger.debug("----INFO----: LOGGED IN USER: " + session.getAttribute("loggedInUser"));
			return "categories";
		}
	}
	
	@RequestMapping(value="/saveCategory", method = RequestMethod.POST)
	public String saveCategory(@RequestParam String categoryName, 
			@RequestParam String categoryIdentifier, @RequestParam String categoryDesc,  HttpSession session, Model model){
		
		IInventoryService inventoryService = new InventoryService();
		Category category = new Category();
		category.setActive(active);
		category.setCategoryDesc(categoryDesc);
		category.setCategoryIdentifier(categoryIdentifier);
		category.setCategoryName(categoryName);
		ReturnMessage returnMessage = inventoryService.saveCategory(category);
		if (returnMessage.isSuccess()){
			logger.debug("---INFO---: Added Category: " + categoryName);
			model.addAttribute("categoryAddSuccess", returnMessage.getMessage());
		}else{
			model.addAttribute("categoryAddError", returnMessage.getMessage());
		}
		
		return "categories";
		
	}
}
