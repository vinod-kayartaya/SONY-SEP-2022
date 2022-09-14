package com.sony.utils;

import java.util.Scanner;

@SuppressWarnings("resource")
public final class KeyboardUtil {
	private KeyboardUtil() {
	}
	
	public static int getInt(String msg) {
		System.out.print(msg);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public static String getString(String msg) {
		System.out.print(msg);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
