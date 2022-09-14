package com.sony.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.sony.utils.DbUtil;
import com.sony.utils.KeyboardUtil;

public class AddShipperUsingStatement {

	public static void main(String[] args) throws Exception {

		int id = KeyboardUtil.getInt("Enter shipper id:");
		String companyName = KeyboardUtil.getString("Enter Company name:");
		String phone = KeyboardUtil.getString("Enter phone:");

		String sql = String.format("insert into shippers values (%d,'%s','%s')", id, companyName, phone);
		System.out.println(sql);
		try (Connection conn = DbUtil.createConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("New shipper data added successfully");

		}
	}

}
