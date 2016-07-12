package com.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventory.connection.DbConnection;
import com.inventory.model.Roles;

public class RolesDAO {
	
	Connection con = DbConnection.getConnection();

	
	public List<Roles> getRoles() {
		List<Roles> roles = new ArrayList<Roles>();
		try {
			Statement stmt = con.createStatement();
			String SQL="select * from roles";
			ResultSet result = stmt.executeQuery(SQL);
			
			
			while (result.next()){
				Roles role = new Roles();
				role.setId(result.getInt("id"));
				role.setRole_desc(result.getString("role_desc"));
				role.setRole_name(result.getString("role_name"));
				roles.add(role);
			}
			
			result.close();
			stmt.close();
			con.close();
			return roles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Roles getRoleForUser(String identifier) {
		
		Roles role = null;
		try {
			Statement stmt = con.createStatement();
			String SQL="select * from roles where roles.id = (select role from users where identifier = '"+identifier+"')";
			ResultSet result = stmt.executeQuery(SQL);
			role = new Roles();
			while(result.next()){	
				role.setId(result.getInt("id"));
				role.setRole_desc(result.getString("role_desc"));
				role.setRole_name(result.getString("role_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public Roles getRole(int id) {
		return null;
	}
}
