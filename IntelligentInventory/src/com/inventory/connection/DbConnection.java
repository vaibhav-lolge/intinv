package com.inventory.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	// JDBC driver name and database URL
//	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	   static final String DB_URL = "jdbc:mysql://127.4.48.2:3306/sunetossystems";
//
//	   //  Database credentials
//	   static final String USER = "adminIGhEhrf";
//	   static final String PASS = "ELTU1f4IufvD";
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/intinv";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static Connection getConnection(){
		   
		   Connection conn = null;
		      try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		      return conn;
		     
	   }

}
