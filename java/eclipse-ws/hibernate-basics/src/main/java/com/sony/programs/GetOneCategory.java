package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.Category;
import com.sony.utils.HibernateUtil;

public class GetOneCategory {
	public static void main(String[] args) {
		Session session = HibernateUtil.createSession();
		
		Category c1 = session.get(Category.class, 1);
		System.out.println(c1);
		
		System.out.println("Products in this category: ");
		c1.getProducts().forEach(System.out::println);
		
	}
}
