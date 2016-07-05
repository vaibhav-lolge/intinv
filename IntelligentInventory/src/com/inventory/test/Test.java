package com.inventory.test;

import com.inventory.dao.UserDAO;

public class Test {
	
	public static void main(String[] args) {
		
		UserDAO userDao = new UserDAO();
		userDao.getUser("vaibhav.lolge");
		
	}
}
