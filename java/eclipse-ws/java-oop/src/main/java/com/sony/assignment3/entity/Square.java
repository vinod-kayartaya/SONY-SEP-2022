package com.sony.assignment3.entity;

public class Square extends Rectangle {
	public Square() {
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public double getSide() {
		return super.getWidth(); // or super.getLength();
	}
	
	public void setSide(double side) {
		super.setWidth(side);
		super.setLength(side);
	}
	
	@Override
	public void setWidth(double width) {
		this.setSide(width);
	}
	
	@Override
	public void setLength(double length) {
		this.setSide(length);
	}
	
	@Override
	public String toString() {
		return String.format("A Square with side=%f, which is a subclass of %s", getSide(), super.toString());
	}
}
