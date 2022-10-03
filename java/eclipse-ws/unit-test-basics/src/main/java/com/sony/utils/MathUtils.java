package com.sony.utils;

public class MathUtils {

	public Long factorial(Integer num) {
		if (num < 0) {
			throw new MathsException("No factorial for negative inputs");
		}
		long f = 1;

		while (num > 1) {
			f *= num--;
		}
		return f;
	}
}
