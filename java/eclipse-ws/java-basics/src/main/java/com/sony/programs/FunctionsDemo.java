package com.sony.programs;

public class FunctionsDemo {
	// this function/method is part of a class (unlike C language)
	// which can only be invoked using an object of this class.
	// Such methods are termed as "non-static method" OR "member method"
	void sayHello() {
		System.out.println("Hello!");
	}
	
	static void welcome() {
		System.out.println("Welcome to Java training.");
	}
	
	static void greet(String name, String city) {
		System.out.printf("Hello %s, how's weather in %s?\n", name, city);
	}
	
	static long square(int num) {
		return num*num;
	}
	
	public static void main(String[] args) {
		// Even though sayHello() is in the same class, main() being
		// a static method, cannot invoke directly. It needs to be 
		// invoked using an object the class.
		FunctionsDemo fd = new FunctionsDemo();
		fd.sayHello();
		
		// main() being a static method, can only invoke other
		// static methods of the class.
		welcome();
		greet("Pranav", "Melbourne");
		long sq = square(1234);
		System.out.printf("Square of %d is %d\n", 1234, sq);
	}
}
