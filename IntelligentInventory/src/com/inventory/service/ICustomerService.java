package com.inventory.service;

import java.util.List;

import com.inventory.model.ReturnMessage;
import com.inventory.model.Roles;
import com.inventory.model.User;

public interface ICustomerService {

	public User logiCustomer(String userId, String password);
	
	public ReturnMessage registerUser(User user);
	
	public List<Roles> getRoles();
	
	public Roles getRole(String identifier);
	
	public User getUser(String identifier);
	
	public List<User> getUserList();
}
