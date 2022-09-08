package com.sony.ui;

import java.util.InputMismatchException;

import com.sony.entity.Product;
import com.sony.service.ProductService;
import com.sony.service.ServiceException;
import com.sony.utils.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	// We shall visit this code again on Monday to undertand how to do it better!!!
	ProductService service = new ProductService();

	public void start() {
		log.trace("App.start() called");
		int choice;

		while ((choice = menu()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("Here is the list of all products:");
				Iterable<Product> products = service.getAllProducts();

				System.out.println("-----------------------------------------------------------------");
				System.out.printf("%4s %-40s %10s %8s%n", "ID", "Description", "Price", "In stock");
				System.out.println("-----------------------------------------------------------------");
				for (Product p : products) {
					System.out.printf("%4s %-40s %10.2f %8s%n", p.getId(), p.getDescription(), p.getPrice(),
							p.getUnitsInStock());
				}
				System.out.println("=================================================================");
				break;
			case 2:

				try {
					System.out.println("Enter details of the new product:");
					int id = KeyboardUtil.getInt("ID             : ");
					String desc = KeyboardUtil.getString("Description    : ");
					double price = KeyboardUtil.getDouble("Price          : ");
					int units = KeyboardUtil.getInt("Units in stock : ");

					Product p = new Product(id, desc, price, units);

					try {
						service.addNewProduct(p);
						System.out.println("New product added successfully!");
					} catch (ServiceException ex) {
						System.out.println("Something went wrong!");
						System.out.println(ex.getMessage());
					}
				} catch (InputMismatchException e) {
					System.out.println("Wrong value for the input. Sorry, you may have to try all over again :-(");
				}

				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

		System.out.println("Thank you for using Product Management System. Have a nice day.");
		log.trace("End of App.start()");
	}

	int menu() {
		log.trace("App.menu() called");

		System.out.println("**** Product Management System ****");
		System.out.println("0. Exit");
		System.out.println("1. List all products");
		System.out.println("2. Add a new product");
		System.out.println("3. Delete product");
		System.out.println("4. Search product");
		System.out.println("5. Edit product details");

		try {
			log.trace("accepting user choice in App.menu()");
			int choice = KeyboardUtil.getInt("Enter your choice: ");
			log.trace("user entered choice {}", choice);
			return choice;
		} catch (InputMismatchException ex) {
			log.warn("Exception while accepting user choice in menu", ex);
		}
		return -1;
	}
}
