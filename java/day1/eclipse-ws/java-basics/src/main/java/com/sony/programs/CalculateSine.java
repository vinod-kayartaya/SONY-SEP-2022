package com.sony.programs;

public class CalculateSine {

	static long factorial(int n) {
		long f = 1;
		while (n > 1) {
			f *= n--;
		}
		return f;
	}

	static double power(double a, int b) {
		double p = 1;
		for (int i = 0; i < b; i++) {
			p *= a;
		}
		return p;
	}

	static double toRadians(double degree) {
		return degree * Math.PI / 180;
	}

	static double sine(double angle) {
		int n = 1;
		double sin = 0.0;
		int sign = 1;

		for (int i = 0; i < 8; i++) {
			sin += sign * power(angle, n) / factorial(n);
			n += 2;
			sign *= -1;
		}
		return sin;
	}

	public static void main(String[] args) {
		System.out.println("sine(45) is " + sine(toRadians(45)));

	}
}
