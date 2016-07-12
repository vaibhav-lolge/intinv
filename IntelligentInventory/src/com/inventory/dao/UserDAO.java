package com.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventory.connection.DbConnection;
import com.inventory.model.ReturnMessage;
import com.inventory.model.User;

public class UserDAO{
	
	
	
	public User getUser(String identifier) {
		
		try {
			User user = new User();
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			String SQL="select * from users where identifier ='" + identifier+"'";
			ResultSet result = stmt.executeQuery(SQL);
			while (result.next()) {
				user.setId(result.getString("id"));
				user.setName(result.getString("name"));
				user.setPassword(result.getString("password"));
				user.setIdentifier(result.getString("identifier"));
				user.setRole(result.getInt("role"));
				user.setActive(result.getInt("active"));
			}
			
			result.close();
			stmt.close();
			con.close();
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	public ReturnMessage saveUser(User user){
		ReturnMessage returnMsg = new ReturnMessage();
		Connection con = DbConnection.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			
			String SQL = "select count(*) from users where identifier = '" +user.getIdentifier()+"'"; 
			ResultSet result = stmt.executeQuery(SQL);
			int count = 0;
			while(result.next()){
				count = result.getInt(1);
			}
			 if (count >0){
				 returnMsg.setSuccess(false);
				 returnMsg.setMessage("Identifier already exist. Please choose another identifier and try again.");
				 return returnMsg;
			 }else{
				SQL = "insert into users (name, password, identifier,role, active) values ('" + user.getName() + "','"
						+ user.getPassword() + "','" + user.getIdentifier() + "'," + user.getRole() + "," + user.getActive() + ")";
				stmt.execute(SQL);
				returnMsg.setSuccess(true);
				returnMsg.setMessage("Registeration Successful! Please login to continue.");
				stmt.close();
				con.close();
				result.close();
				return returnMsg;
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setSuccess(false);
			returnMsg.setMessage("Some error has occured while processing your request. Please cantact IT support.");
			return returnMsg;
		}
	}
	
	public List<User> getUsers(String name) {
		return null;
	}

	
	public void update(User user) {
	}




	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		Connection con = DbConnection.getConnection();
		try {
			Statement stmt = con.createStatement();
			String SQL = "select * from users";
			ResultSet result = stmt.executeQuery(SQL);
			
			while (result.next()) {
				User user = new User();
				user.setId(result.getString("id"));
				user.setName(result.getString("name"));
				user.setPassword(result.getString("password"));
				user.setIdentifier(result.getString("identifier"));
				user.setRole(result.getInt("role"));
				user.setActive(result.getInt("active"));
				userList.add(user);
			}
			
			result.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
