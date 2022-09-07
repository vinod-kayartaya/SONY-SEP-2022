package com.sony.programs;

import com.sony.utils.KeyboardUtil;

public class EvenOrOdd {

	public static void main(String[] args) {

		int num = KeyboardUtil.getInt("Enter a number: ");

		if (num % 2 == 0) {
			System.out.println("Even number.");
		} else {
			System.out.println("Odd number.");
		}

	}
}
