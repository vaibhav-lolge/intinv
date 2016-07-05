package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalExceptionController {
	
	@RequestMapping(value="/404")
	public String exceptionNotFoundPage(){		
		return "error";
	}
	
	@RequestMapping(value="/400")
	public String exceptionNotFoundResource(){		
		return "error";
	}
	
	@RequestMapping(value="/500")
	public String exceptionGeneral(){		
		return "error";
	}

}
