package com.sony.assignment3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shape {

	private String color = "red";
	private boolean filled = true;

	@Override
	public String toString() {
		return String.format("A Shape with color of %s and %sfilled", color, filled ? "" : "not ");
	}

}
