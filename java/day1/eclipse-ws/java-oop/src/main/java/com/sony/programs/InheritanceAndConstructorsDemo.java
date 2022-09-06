package com.sony.programs;

import com.sony.entity.Printable;

import lombok.Getter;
import lombok.Setter;

// NOTE: it is highly recomendded that we create one class per source file.
// This is only for the sake of simplicity, so that we can refer to all the classes in the same file.

@Setter
@Getter
class Product {
	private int id;
	private String description;
	private double unitPrice;

	// default/no-arg constructor - only for the sake of good practice
	public Product() {
	}

	// parameterized/overloaded constructor - provides flexibility of creating
	// objects with values
	public Product(int id, String description, double unitPrice) {
		this.id = id;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	// custom method to print the details of the product
	public void print() {
		System.out.printf("ID           %s\n", id);
		System.out.printf("Description  %s\n", description);
		System.out.printf("Unit price   Rs.%s\n", unitPrice);
	}
}







enum ScreenTypes {
	LCD, LED, TFT
}

@Getter
@Setter
class Laptop extends Product implements Printable {
	private double screenSize;
	private ScreenTypes screenType = ScreenTypes.LED; // LCD, LED, TFT
	private String ram;
	private String cpu;
	private String storage;

	// default/no-arg constructor for better practice
	public Laptop() {
	}

	public Laptop(int id, String description, double unitPrice, double screenSize, ScreenTypes screenType) {
		// 1. calling a superclass constructor can only be done inside a constructor
		// 2. call to the superclass must be the first statement in a constructor (if
		// done)
		super(id, description, unitPrice); // invokes the respective superclass constructor
		// note that super keyword is used like a function call
		this.screenSize = screenSize;
		this.screenType = screenType;
	}

	// re-writing the inherited method is called as "overriding"
	@Override
	public void print() {
		super.print(); // note that super is used here as a reference
		System.out.printf("Screen size  %s\n", this.screenSize);
		System.out.printf("Screen type  %s\n", this.screenType);
		System.out.printf("RAM          %s\n", this.ram);
		System.out.printf("CPU          %s\n", this.cpu);
		System.out.printf("Storage      %s\n", this.storage);
	}

}

public class InheritanceAndConstructorsDemo {

	public static void main(String[] args) {

		Product p1 = new Product();
		p1.setId(12);
		p1.setDescription("Coca cola 2ltr");
		p1.setUnitPrice(180.0);

		Laptop p2 = new Laptop(11, "Lenovo Z560", 45000, 14, ScreenTypes.LED);
		p2.setCpu("Intel i9 2900GHz 6 core");
		p2.setRam("16Gi");
		p2.setStorage("1 TB");

		p1.print();
		System.out.println();
		p2.print();

	}

}
