package com.sony.programs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.sony.entity.Customer;
import com.sony.entity.Employee;
import com.sony.entity.LineItem;
import com.sony.entity.Order;
import com.sony.utils.HibernateUtil;

public class GetOrderInformationForId {

	static String format(Date dt) {
		String pattern = "EEEE d MMMM, yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dt);
	}

	public static void main(String[] args) {
		int orderId = 10248;
		Session session = HibernateUtil.createSession();
		Order ord = session.get(Order.class, orderId);
		session.close();

		System.out.println("Order ID   : " + ord.getOrderId());
		System.out.println();

		System.out.println("Customer who placed this order: ");
		Customer c1 = ord.getCustomer();
		System.out.println("Name: " + c1.getCompanyName());
		System.out.println("City: " + c1.getAddress().getCity());
		System.out.println();

		System.out.println("Employee who processed this order: ");
		Employee e1 = ord.getEmployee();
		System.out.printf("Name: %s %s (%s)%n", e1.getFirstname(), e1.getLastname(), e1.getTitle());
		Employee m1 = e1.getReportsTo();
		if (m1 != null) {
			System.out.printf("Manager: %s %s (%s)%n", m1.getFirstname(), m1.getLastname(), m1.getTitle());
		}
		System.out.println();

		System.out.println("Order date: " + format(ord.getOrderDate()));
		System.out.println("Rqrd date : " + format(ord.getRequiredDate()));
		System.out.println("Shipped on: " + format(ord.getShippedDate()));
		System.out.println();

		System.out.println("This order was shipped by: ");
		System.out.println("Shipping company name: " + ord.getShipper().getCompanyName());
		System.out.println("Phone number         : " + ord.getShipper().getPhone());
		System.out.println("Frieght charges      : $" + ord.getFreight());
		System.out.println();

		System.out.println("This order was shipped to: ");
		System.out.println("Name      : "+ ord.getShipToName());
		System.out.println("City      : " + ord.getShipToAddress().getCity());
		System.out.println("Country   : " + ord.getShipToAddress().getCountry());
		System.out.println();
		
		System.out.println("Products in this order:");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf ("%-35s %15s %15s %10s %10s%n", "Product", "Current price", "Sold at", "Qty", "Discount%");
		System.out.println("-----------------------------------------------------------------------------------------");
		double orderTotal = 0;
		
		for(LineItem li: ord.getLineItems()) {
			orderTotal += (li.getUnitPrice()*li.getQuantity()*(1-li.getDiscount()));
			System.out.printf ("%-35s %15s %15s %10s %10s%n", 
					li.getProduct().getProductName(),
					li.getProduct().getUnitPrice(),
					li.getUnitPrice(),
					li.getQuantity(),
					li.getDiscount()*100);
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("Order total: $ %-10.2f%n", orderTotal);
		System.out.println("-----------------------------------------------------------------------------------------");
		
	}
}











