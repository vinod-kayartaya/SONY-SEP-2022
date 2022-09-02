package com.sony.programs;

import com.sony.utils.KeyboardUtil;

public class CheckNumberForPrime {

	public static boolean isPrime(int n) {

		// take the denominator from 2 to n-1
		int d = 2, limit = (int) Math.sqrt(n); // limit = n/2
		// int pass = 0;
		while (d <= limit) { // while (d<n) {
			// pass++;
			if (n % d == 0) {
				return false;
			}
			d++;
		}
		// System.out.println("Total number of loops = " + pass);
		return true;
	}

	public static void main(String[] args) {

		int input = KeyboardUtil.getInt("Enter a number: ");
		if (isPrime(input)) {
			System.out.printf("%d is a prime number\n", input);
		} else {
			System.out.printf("%d is a composite number\n", input);
		}

	}

}
