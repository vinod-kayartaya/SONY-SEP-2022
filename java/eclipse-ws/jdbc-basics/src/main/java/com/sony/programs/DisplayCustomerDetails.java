package com.sony.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayCustomerDetails {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://ec2-54-211-195-168.compute-1.amazonaws.com:8880/vindb";
		String username = "root";
		String password = "Welcome#123";
		String sql = "select * from customers";

		try(Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			System.out.printf("%3s %-30s %-30s%n", "Id", "Name", "City");
			while(rs.next()) {
				System.out.printf("%3d %-30s %-30s%n",
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
			}
		}
	}
}
