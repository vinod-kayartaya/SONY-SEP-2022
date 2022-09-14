package com.sony.programs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabaseServer {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:h2:tcp://localhost/~/vindb";
		String user = "root";
		String password = "Welcome#123";

		Connection conn = DriverManager.getConnection(url, user, password);

		System.out.println("conn is an object of " + conn.getClass());

	}

}
