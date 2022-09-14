package com.sony.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.sony.utils.DbUtil;

public class AddShippersFromCsvUsingPreparedStatement {

	public static void main(String[] args) {
		String sql = "insert into shippers values (?,?,?)";

		try (Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				FileReader reader = new FileReader("shippers_data.txt");
				BufferedReader in = new BufferedReader(reader);) {

			in.readLine(); // skip the header

			String line;
			int count = 0;
			while ((line = in.readLine()) != null) {
				String[] arr = line.split(",");
				try {
					int id = Integer.parseInt(arr[0]);
					String companyName = arr[1];
					String phone = arr[2];

					stmt.setInt(1, id);
					stmt.setString(2, companyName);
					stmt.setString(3, phone);
					stmt.execute();
					System.out.println("Added shipper data - " + Arrays.toString(arr));
					count++;

				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Not enough values: " + Arrays.toString(arr));
				} catch (NumberFormatException ex) {
					System.out.println("ID is not a number: " + arr[0]);
				} catch (SQLException ex) {
					System.out.println("Something went wrong- " + ex.getMessage());
				}

			}
			System.out.println("Added " + count + " shipper records");
		} // conn, stmt, reader and in get closed here 
		catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}
