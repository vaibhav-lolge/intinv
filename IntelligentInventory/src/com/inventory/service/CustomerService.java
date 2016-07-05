package com.inventory.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inventory.dao.RolesDAO;
import com.inventory.dao.UserDAO;
import com.inventory.model.Roles;
import com.inventory.model.User;
import com.inventory.util.EncryptPassword;

public class CustomerService implements ICustomerService {
	
	ApplicationContext context;
	UserDAO userDao;
	RolesDAO rolesDao;
	
	
	private void initDAOConnection(){
		 this.context= new ClassPathXmlApplicationContext("Beans.xml");		 
	}

	@Override
	public User logiCustomer(String userId, String password) {
		
		
		initDAOConnection();
		userDao= (UserDAO)context.getBean("userDAO");
	
		User user = userDao.getUser(userId);	
		
		if(user!=null){
			if(user.getPassword().equals(EncryptPassword.getSerucerPassword(password))){
				return user;
			}
		}		
			return null;
	}

	@Override
	public boolean registerUser(String name, String password, String identifier, int role, int active) {
		initDAOConnection();
		userDao= (UserDAO)context.getBean("userDAO");
		
		String securedPassword = ""; 
			securedPassword = EncryptPassword.getSerucerPassword(password);
		
		 User user = new User();
		 user.setIdentifier(identifier);
		 user.setName(name);
		 user.setPassword(securedPassword);
		 user.setRole(role);
		 user.setActive(active);
		 
		return userDao.saveUser(user);
	}
	
	
	@Override
	public List<Roles> getRoles() {
		initDAOConnection();
		rolesDao= (RolesDAO)context.getBean("rolesDAO");
		List <Roles> roles = rolesDao.getRoles();
		
		return roles;
	}

	@Override
	public Roles getRole(String identifier) {
		initDAOConnection();
		userDao= (UserDAO)context.getBean("userDAO");
		Roles role = userDao.getRoleForUser(identifier);
		return role;
	}
	
	@Override
	public User getUser(String identifier) {

		return null;
	}

	@Override
	public List<User> getUserList() {
		userDao= (UserDAO)context.getBean("userDAO");
		List<User> userList = userDao.getUserList();
		return userList;
	}

	
	

}
