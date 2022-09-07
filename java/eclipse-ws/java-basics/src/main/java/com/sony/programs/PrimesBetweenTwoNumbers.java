package com.sony.programs;

import com.sony.utils.KeyboardUtil;

public class PrimesBetweenTwoNumbers {

	public static void main(String[] args) {

		int start = KeyboardUtil.getInt("Enter the starting number: ");
		int end = KeyboardUtil.getInt("Enter the ending number: ");

		for (int i = start, j = 1; i <= end; i++) {
			if (CheckNumberForPrime.isPrime(i)) {
				System.out.print(i + ", ");
				
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}

		System.out.println();
	}
}
