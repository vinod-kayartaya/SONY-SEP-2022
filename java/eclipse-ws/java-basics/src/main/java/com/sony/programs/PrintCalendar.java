package com.sony.programs;

import com.sony.utils.KeyboardUtil;

public class PrintCalendar {

	static boolean isLeap(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	static int daysInYear(int year) {
		return isLeap(year) ? 366 : 365;
	}

	static int daysInMonth(int month, int year) {
		switch (month) {
		case 2:
			return isLeap(year) ? 29 : 28;
		case 4, 6, 9, 11:
			return 30;
		default:
			return 31;
		}
	}

	static int julianDate(int day, int month, int year) {
		int jd = 0;
		// no.of days from 1/1/1900 to 31/12/(year-1)
		for (int y = 1900; y < year; y++) {
			jd += daysInYear(y);
		}

		// 1/1/y to (maxDays)/(month-1)/year
		for (int m = 1; m < month; m++) {
			jd += daysInMonth(m, year);
		}
		// days till "day"
		jd += day;

		return jd;
	}

	public static void main(String[] args) {
		
		int m = KeyboardUtil.getInt("Enter month: ");
		int y = KeyboardUtil.getInt("Enter year: ");

		printCalendar(m, y);
	}

	static void printCalendar(int month, int year) {
		int maxDays = daysInMonth(month, year);
		int jd = julianDate(1, month, year);
		int offset = jd % 7;

		System.out.println("Su Mo Tu We Th Fr Sa");
		System.out.println("--------------------");
		for (int i = 0; i < offset; i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= maxDays; i++) {
			System.out.printf("%2d ", i);
			if ((i+offset) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
