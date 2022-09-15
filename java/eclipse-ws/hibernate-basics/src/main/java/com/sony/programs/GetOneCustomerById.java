package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.Customer;
import com.sony.utils.HibernateUtil;

public class GetOneCustomerById {

	public static void main(String[] args) {
		Session session = HibernateUtil.createSession();
		Customer cust = session.get(Customer.class, "ALFKI");
		session.close();
		
		System.out.println("Company Name     : " + cust.getCompanyName());
		System.out.println("Contact person   : " + cust.getContactName());
		System.out.println("Contact title    : " + cust.getContactTitle());
		System.out.println("Address          : " + cust.getAddress().getStreeAddress());
		System.out.println("City             : " + cust.getAddress().getCity());
		System.out.println("Region           : " + cust.getAddress().getRegion());
		System.out.println("Country          : " + cust.getAddress().getCountry());
		System.out.println("Postal code      : " + cust.getAddress().getPostalCode());
		System.out.println("Phone number     : " + cust.getPhone());
		System.out.println("Fax number       : " + cust.getFax());
	}
}
