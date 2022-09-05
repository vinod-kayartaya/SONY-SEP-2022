package com.sony.programs;

import com.sony.entity.Circle;

public class TestCircleClass {

	public static void main(String[] args) {
		Circle c1;
		Circle c2;
		Circle c3;
		
		c1 = new Circle();
		c2 = new Circle(12.34);
		c3 = new Circle(56.78, "blue");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
