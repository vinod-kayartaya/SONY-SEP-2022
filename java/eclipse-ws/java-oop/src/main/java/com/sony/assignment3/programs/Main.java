package com.sony.assignment3.programs;

import com.sony.assignment3.entity.Circle;
import com.sony.assignment3.entity.Rectangle;
import com.sony.assignment3.entity.Shape;
import com.sony.assignment3.entity.Square;

public class Main {

	public static void main(String[] args) {
		
		Shape[] shapes = {
				new Circle(12.34, "blue", false),
				new Rectangle(12.34, 56.78, "black", true),
				new Square(98.76, "white", true)
		};
		
		for(Shape s: shapes) {
			System.out.println(s);
			
			if(s instanceof Circle c) {
				System.out.println("Area of circle = " + c.getArea() + ", and its perimeter = " + c.getPerimeter());
			}
			else if(s instanceof Square sq) {
				System.out.println("Area of square = " + sq.getArea() + ", and its perimeter = " + sq.getPerimeter());
			}
			else if(s instanceof Rectangle r) {
				System.out.println("Area of rectangle = " + r.getArea() + ", and its perimeter = " + r.getPerimeter());
			}
			System.out.println();
		}
		
	}
}
