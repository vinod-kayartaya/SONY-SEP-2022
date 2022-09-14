package com.sony.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbUtil {
	private DbUtil() {
	}
	
	public static Connection createConnection() throws SQLException {
		String url = "jdbc:h2:tcp://localhost/~/vindb";
		String user = "root";
		String password = "Welcome#123";
		
		return  DriverManager.getConnection(url, user, password);
	}
}
