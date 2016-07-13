package com.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		Connection con = DbConnection.getConnection();
		try {
			Statement stmt = con.createStatement();
			String SQL = "select * from category";
			ResultSet result = stmt.executeQuery(SQL);
			while(result.next()){
				Category category = new Category();
				category.setActive(result.getInt("active"));
				category.setCategoryDesc(result.getString("categoryDescription"));
				category.setCategoryIdentifier(result.getString("categoryId"));
				category.setCategoryName(result.getString("categoryName"));
				categoryList.add(category);
			}
			result.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	public Category getCategory(String categoryIdentifier) {
		try {
			Category category = new Category();
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			String SQL="select * from category where categoryId ='" + categoryIdentifier+"'";
			ResultSet result = stmt.executeQuery(SQL);
			while (result.next()) {
				category.setActive(result.getInt("active"));
				category.setCategoryDesc(result.getString("categoryDescription"));
				category.setCategoryIdentifier(result.getString("categoryId"));
				category.setCategoryName(result.getString("categoryName"));
			}
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ReturnMessage updateCategory(Category editedCategory) {
		
		ReturnMessage returnMsg = new ReturnMessage();
		Connection con = DbConnection.getConnection();
		
		try {
			Statement stmt = con.createStatement();				
			String SQL = "update category set active="+editedCategory.getActive()+", categoryName='"+editedCategory.getCategoryName()+"', categoryDescription='"+editedCategory.getCategoryDesc()+"' where categoryId = '"+editedCategory.getCategoryIdentifier()+"'";
				stmt.execute(SQL);
				returnMsg.setSuccess(true);
				returnMsg.setMessage("Changes to the Category updated successfully!");
				stmt.close(); 
				con.close();
				return returnMsg;
			 
		} catch (Exception e) {
			returnMsg.setSuccess(false);
			returnMsg.setMessage("Some error has occured while processing your request. Please cantact IT support.");
			return returnMsg;
		}
	}

}
