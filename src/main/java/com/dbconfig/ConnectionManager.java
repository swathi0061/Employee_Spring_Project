package com.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	static Connection connection = null;
	
	public static Connection getConnectionManager() {
		try {
			String dburl="jdbc:mysql://localhost:3306/emp_project";
			String username="root";
			String password ="root";
			String driver ="com.mysql.cj.jdbc.Driver";
			
			Class.forName(driver);
			connection = DriverManager.getConnection(String.valueOf(dburl),username,password);
		}
		catch(Exception e) {
			e.getMessage();
		}
		return connection;
	}
}
