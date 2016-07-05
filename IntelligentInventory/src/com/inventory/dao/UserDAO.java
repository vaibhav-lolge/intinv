package com.inventory.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.inventory.mapper.RolesMapper;
import com.inventory.mapper.UserMapper;
import com.inventory.model.Roles;
import com.inventory.model.User;

public class UserDAO{
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	

	
	public void save(User user) {		
		
	}

	
	public User getUser(String identifier) {
		String SQL="select * from users where identifier =?";
		User user= jdbcTemplate.queryForObject(SQL, new Object[]{identifier}, new UserMapper());
		return user;
	}

	
	public List<User> getUsers(String name) {
		return null;
	}

	
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean saveUser(User user) {
		String SQL = "insert into users (name, password, identifier,role, active) values (?,?,?,?,?)";
		int returnValue = jdbcTemplate.update(SQL, user.getName(), user.getPassword(), user.getIdentifier(), user.getRole(), user.getActive());
		if(returnValue > 0)
			return true;
		else
			return false;
	}


	public Roles getRoleForUser(String identifier) {
		String SQL = "select * from roles where roles.id = (select role from users where identifier = ?)";
		Roles role = jdbcTemplate.queryForObject(SQL, new Object[]{identifier}, new RolesMapper());
		return role;
	}


	public List<User> getUserList() {
		String SQL = "select * from users";
		List<User> userList = jdbcTemplate.query(SQL, new UserMapper());
		return userList;
	}

}
