package com.sony.programs;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.sony.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TreeSetOfProductsDemo {

	// An object of this class is a comparator object, that knows
	// the order of two products based on their names
	static class ProductNameComparator implements Comparator<Product> {
		@Override
		public int compare(Product p1, Product p2) {
			return p1.getName().compareTo(p2.getName());
		}
	}

	public static void main(String[] args) {

		// Set<Product> products = new TreeSet<>(new ProductNameComparator());
		Set<Product> products = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

		products.add(new Product(89, "Logitech Optical Mouse", 2350));
		products.add(new Product(78, "Apple Ear Plugs", 2400));
		products.add(new Product(22, "Apple Magic Mouse", 8550));
		products.add(new Product(45, "Screen guard for smartphone", 350));
		products.add(new Product(12, "Natarj Pencil box", 250));
		products.add(new Product(77, "Samsung LCD Monitor", 6500));

		for (Product pr : products) {
			log.debug("{}", pr);
		}
	}
}
