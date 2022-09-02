package com.sony.programs;

import com.sony.utils.KeyboardUtil;

public class CheckForDateValidatity {

	public static void main(String[] args) {
		String dt;

		dt = KeyboardUtil.getString("Enter a date in DD/MM/YYYY format: ");
		// for the time being, we shall assume the positive use cases

		String strDay = dt.substring(0, 2);
		String strMonth = dt.substring(3, 5);
		String strYear = dt.substring(6);

		int day = Integer.parseInt(strDay);
		int month = Integer.parseInt(strMonth);
		int year = Integer.parseInt(strYear);

		// validation rule 1: year must be >=1900 and <= 9999
		if (year < 1900 || year > 9999) {
			System.out.println("Invalid value for year.");
			return;
		}

		// validation rule 2: month must be between 1 and 12
		if (month < 1 || month > 12) {
			System.out.println("Invalid value for month.");
			return;
		}

		// validation rule 3: day must be >=1 and <= MAX_DAYS
		// where MAX_DAYS is 28, 29, 30 or 31 depending on the month
		int maxDays = 31; // for the seven months that have 31 days
		if (month == 2) {
			// every 4th year is a leap year with an exception to the 100th year
			// or every 400th year is a leap year
			if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			maxDays = 30;
		}

		if (day < 1 || day > maxDays) {
			System.out.println("Invalid value for day.");
			return;
		}

		System.out.println("The input represents a valid date.");

	}
}
