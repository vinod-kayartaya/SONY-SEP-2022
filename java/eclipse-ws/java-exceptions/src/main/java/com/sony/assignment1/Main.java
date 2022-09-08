package com.sony.assignment1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int intCount = 0;
		int nonIntCount = 0;
		String ints = "";
		String nonInts = "";
		String ans = "";
		while (!ans.equalsIgnoreCase("no")) {
			System.out.print("Enter an integer: ");
			String input = sc.nextLine();

			try {
				int num = Integer.parseInt(input);
				sum += num;
				intCount++;
				ints += input + ", ";
			} catch (NumberFormatException ex) {
				System.out.println("OOPS! You did not enter an integer!");
				nonIntCount++;
				nonInts += input + ", ";
			}

			System.out.print("Do you want to input one more? (yes/no) [yes] ");
			ans = sc.nextLine();
		}

		System.out.printf("Number of inputs = %d%n", intCount + nonIntCount);
		System.out.printf("Number of integer inputs = %d%n", intCount);
		System.out.printf("Number of non-integer inputs = %d%n", nonIntCount);
		System.out.printf("Sum of all integer inputs = %d%n", sum);
		System.out.printf("The integer inputs = %s%n", ints.substring(0, ints.length() - 2));
		System.out.printf("The non-integer inputs = %s%n", nonInts.substring(0, nonInts.length() - 2));

		sc.close();
	}
}
