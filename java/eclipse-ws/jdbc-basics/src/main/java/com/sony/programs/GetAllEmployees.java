package com.sony.programs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sony.utils.DbUtil;

public class GetAllEmployees {
	static void line(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String sql = "select * from employees";
		try (Connection conn = DbUtil.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			System.out.printf("%2s %-20s %20s %20s%n", "ID", "Name", "DOB", "DOJ");
			line(65);
			while (rs.next()) {
				int empno = rs.getInt("employee_id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				Date dob = rs.getDate("birth_date");
				Date doj = rs.getDate("hire_date");
				System.out.printf("%2d %-20s %20s %20s%n", empno, fname + ' ' + lname, dob, doj);
			}
			line(65);
		} // conn, stmt and rs will be closed here
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
