package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.Supplier;
import com.sony.utils.HibernateUtil;

public class GetOneSupplierById {

	public static void main(String[] args) {

		Session session = HibernateUtil.createSession();
		Supplier sup = session.get(Supplier.class, 1); 
		session.close();
		
		System.out.println(sup);
		sup.getProducts().forEach(System.out::println);
		

	}
}
