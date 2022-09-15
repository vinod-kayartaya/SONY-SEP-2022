package com.sony.programs;

import java.util.Scanner; // find all usages of "Scanner" and replace the same with "java.util.Scanner"

@SuppressWarnings({"resource"})
public class ReadFromKeyboardDemo {

	
	public static void main(String[] args) {
		
		Scanner sc; // a variable that is capable of "scanning" from various sources (like file, keyboard, ..)
		sc = new Scanner(System.in); // initialized to be able to scan from keyboard
		
		int age;
		System.out.println("Enter your age: ");
		age = sc.nextInt(); // read an int from the keyboard
		
		// sc.nextLine(); // read till the end of the line
		sc = new Scanner(System.in) ; // OR use a new scanner, whose keyboard buffer is empty 
		
		String name;
		System.out.println("Enter your name: ");
		name = sc.nextLine(); // read a string (complete line) from the keyboard
		
		System.out.printf("%s is %d years old\n", name, age);
		
	}
}
