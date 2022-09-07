package com.sony.assignment1.programs;

import com.sony.assignment1.entity.Circle;
import com.sony.assignment1.entity.Cylinder;

public class Main {

	public static void main(String[] args) {
		Circle[] circles = {
				new Cylinder(12.34),
				new Cylinder(56.78, 5.0),
				new Cylinder(90.12, 7.5, "blue")
			};
		
		for(Circle c: circles) {
			System.out.println("Area of circular region of the cylinder = " + c.getArea());
			
			if(c instanceof Cylinder c1) {
				System.out.println("Volume of the cylinder = " + c1.getVolume());
			}
		}
	}
}
