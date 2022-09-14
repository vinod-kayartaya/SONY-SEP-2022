package com.sony.programs;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintAvailableDrivers {

	public static void main(String[] args) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		System.out.println("Here are the list of the drivers registered with DriverManager:");
		while (drivers.hasMoreElements()) {
			Driver dr = drivers.nextElement();
			System.out.println(dr.getClass().getName());
		}
		System.out.println("Thats all");

	}

}
