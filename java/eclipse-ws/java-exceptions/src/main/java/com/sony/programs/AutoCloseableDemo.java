package com.sony.programs;

import com.sony.db.Database;

public class AutoCloseableDemo {

	public static void main(String[] args) {

		// only classes that implement java.lang.AutoCloseable 
		// interface can be used
		// in the try-with-resources block
		try (Database db = new Database(); ) {
			
			db.causeProblem();
			
			System.out.println("End of try block");
		} // db.close() is called here 
		catch (Exception ex) {
			System.out.println("Inside the catch block");
		} finally {
			System.out.println("Inside the finally block");
		}

	}
}
