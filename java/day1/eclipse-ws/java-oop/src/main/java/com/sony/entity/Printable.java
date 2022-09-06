package com.sony.entity;

public interface Printable {

	// public static final
	int pageSize = 20;

	// public abstract
	void print();

	// public default (introduced in JDK 1.8, to avoid unncessary implementations in the
	// classes that might have already implemented this interface
	default void printAsJson() {
		System.out.println("This is dummy default implementation");
	}

}
