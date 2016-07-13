package com.inventory.controller;

import java.util.List;

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
private static int active = 1;
private static int inActive = 0;//default deactivated account.
	
	@RequestMapping("/categories")
	public String categories(HttpSession session, Model model){
		
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
	
	@RequestMapping(value="/categoriesList")
	public String categoryList(HttpSession session, Model model){
		IInventoryService inventoryService = new InventoryService();
		
		logger.debug("----INFO----: HOME PAGE.");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			logger.debug("----INFO----: LOGGED IN USER: " + session.getAttribute("loggedInUser"));
			
			List<Category> categoryList = inventoryService.getCategoryList();
			model.addAttribute("categoryList",categoryList);	
			return "categoriesList";
		}
	}

	
	@RequestMapping(value="/searchCategory")
	public String searchCategory(HttpSession session, Model model){
		
		
		logger.debug("----INFO----: HOME PAGE.");
		if(session.getAttribute("loggedInUser")==null){
			return "login";
		}
		else{
			logger.debug("----INFO----: LOGGED IN USER: " + session.getAttribute("loggedInUser"));
			return "editCategory";
		}
	}
	
	@RequestMapping(value="/searchCategory", method = RequestMethod.POST)
	public String searchCategory(@RequestParam String categoryIdentifier,  HttpSession session, Model model){
		
		IInventoryService inventoryService = new InventoryService();
		Category searchedCategory = null;		
		searchedCategory = inventoryService.searchCategory(categoryIdentifier);
		if (searchedCategory != null){
			logger.debug("---INFO---: Category Found: " + categoryIdentifier);
			model.addAttribute("searchedCategory", searchedCategory);
			session.setAttribute("searchedCategory", searchedCategory);
		}else{
			model.addAttribute("searchedCategoryError", "No Category with the searched criteria was found! Please try again.");
		}
		return "editCategory";
		
	}

	@RequestMapping(value="/editCategory", method = RequestMethod.POST)
	public String editCategory(@RequestParam String categoryName,@RequestParam String categoryDesc, @RequestParam String activateOption,  HttpSession session, Model model){
		String categoryNameValidation ="";
		String categoryDescValidation ="";
		String categoryActivateValidation="";
		
		IInventoryService inventoryService = new InventoryService();
		
		Category searchedCategory = (Category)session.getAttribute("searchedCategory");
		Category editedCategory = new Category();
		editedCategory.setCategoryIdentifier(searchedCategory.getCategoryIdentifier());
		if(categoryName.length()==0){
			categoryNameValidation = "Category Name is mandatory. If it is left empty or unchanged, the previous value will be saved.";
			editedCategory.setCategoryName(searchedCategory.getCategoryName());
		}else{
			editedCategory.setCategoryName(categoryName);
			categoryNameValidation= "Category Name changed.";
		}
		
		if(categoryDesc.length()==0){
			categoryDescValidation= "Category description is empty and will be saved as empty.";
			
		}else{
			editedCategory.setCategoryDesc(categoryDesc);
			categoryDescValidation= "Category description is saved.";
		}
		
		if(Integer.parseInt(activateOption) == 0){
			categoryActivateValidation= "Category In-Activated.";
			editedCategory.setActive(inActive);
		}else{
			categoryActivateValidation= "Category Activated.";
			editedCategory.setActive(active);
		}
		
		
		ReturnMessage returnMessage = inventoryService.updateCategory(editedCategory);
		
		if (returnMessage.isSuccess()) {
			
			model.addAttribute("categoryNameValidation",categoryNameValidation);
			model.addAttribute("categoryDescValidation",categoryDescValidation);
			model.addAttribute("categoryActivateValidation" , categoryActivateValidation);
			model.addAttribute("categorySaveSuccess",returnMessage.getMessage());
			
		} else {
			model.addAttribute("categorySaveError",returnMessage.getMessage());
		}
		
		return "editCategory";
		
	}

}
