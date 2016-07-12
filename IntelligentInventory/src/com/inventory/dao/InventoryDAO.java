package com.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.inventory.connection.DbConnection;
import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;

public class InventoryDAO {
	
	public ReturnMessage saveCategory(Category category){
		ReturnMessage returnMsg = new ReturnMessage();
		Connection con = DbConnection.getConnection();
		
		try {
			Statement stmt = con.createStatement();				
			String SQL = "select count(*) from category where categoryId = '" +category.getCategoryIdentifier()+"'"; 
			
			ResultSet result = stmt.executeQuery(SQL);
			int count = 0;
			while(result.next()){
				count = result.getInt(1);
			}
			 if (count >0){
				 returnMsg.setSuccess(false);
				 returnMsg.setMessage("Category identifier already exist. Please choose another identifier and try again.");
				 return returnMsg;
			 }else{
				SQL = "insert into category (categoryId, categoryName, categoryDescription,active) values ('" + category.getCategoryIdentifier() + "','"
						+ category.getCategoryName() + "','" + category.getCategoryDesc() + "'," + category.getActive() + ")";
				stmt.execute(SQL);
				returnMsg.setSuccess(true);
				returnMsg.setMessage("Category added successfully!");
				stmt.close();
				con.close();
				result.close();
				return returnMsg;
			 }
		} catch (Exception e) {
			returnMsg.setSuccess(false);
			returnMsg.setMessage("Some error has occured while processing your request. Please cantact IT support.");
			return returnMsg;
		}
	}

}
