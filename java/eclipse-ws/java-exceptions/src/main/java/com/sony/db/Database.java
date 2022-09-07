package com.sony.db;

public class Database implements AutoCloseable{
	
	public Database() {
		System.out.println("The constructor com.sony.db.Database() called");
	}

	@Override
	public void close() throws Exception {
		System.out.println("com.sony.db.Database.close() called");
	}

	public void causeProblem() {
		System.out.println("Causing a problem deliberately...");
		throw new RuntimeException("Throwing an exception just like that...");
	}
	
}
