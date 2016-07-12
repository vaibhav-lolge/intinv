package com.inventory.service;

import java.util.List;

import com.inventory.dao.RolesDAO;
import com.inventory.dao.UserDAO;
import com.inventory.model.ReturnMessage;
import com.inventory.model.Roles;
import com.inventory.model.User;
import com.inventory.util.EncryptPassword;

public class CustomerService implements ICustomerService {
	
	UserDAO userDao = new UserDAO();
	RolesDAO rolesDao = new RolesDAO();
	
	

	@Override
	public User logiCustomer(String userId, String password) {
	
		User user = userDao.getUser(userId);	
		
		if(user!=null){
			if(user.getPassword().equals(EncryptPassword.getSerucerPassword(password))){
				return user;
			}
		}		
			return null;
	}

	@Override
	public ReturnMessage registerUser(User user) {
		
		String securedPassword = ""; 
			securedPassword = EncryptPassword.getSerucerPassword(user.getPassword());
		 user.setPassword(securedPassword);
		 return userDao.saveUser(user);
	}
	
	@Override
	public List<Roles> getRoles() {
		List <Roles> roles = rolesDao.getRoles();
		return roles;
	}

	@Override
	public Roles getRole(String identifier) {
		Roles role = rolesDao.getRoleForUser(identifier);
		return role;
	}
	
	@Override
	public User getUser(String identifier) {
		return null;
	}

	@Override
	public List<User> getUserList() {
		List<User> userList = userDao.getUserList();
		return userList;
	}

	
	

}
