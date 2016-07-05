package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet result, int rowNumber) throws SQLException {
		
		User user = new User();
		user.setName(result.getString("name"));
		user.setIdentifier(result.getString("identifier"));
		user.setPassword(result.getString("password"));
		user.setId(result.getString("id"));
		user.setRole(result.getInt("role"));
		user.setActive(result.getInt("active"));
		return user;
	}

}
