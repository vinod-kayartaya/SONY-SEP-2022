package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.Product;
import com.sony.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetOneProduct {
	public static void main(String[] args) {
		Session session = HibernateUtil.createSession();
		
		log.debug("calling session.get()");
		Product p = session.get(Product.class, 12);
		log.debug("datatype of p is {}", p.getClass().getName());
		log.debug("session.get() finished");
		
		log.debug("trying to access members of p");
		log.debug("product with id 12 = {}", p);
		log.debug("calling session.close()");
		session.close();
		log.debug("session is closed");
		
		System.out.println("Product = " + p);
		System.out.println("Category= " + p.getCategory());
		System.out.println("Supplier= " + p.getSupplier());
	}

	
}
