package com.sony.programs;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sony.entity.Product;
import com.sony.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindAndUpdateProductPrice {
	public static void main(String[] args) {
		
		// 1st session (uses a JDBC connection object)
		Session session1 = HibernateUtil.createSession();
		Product pr = session1.get(Product.class, 78);
		log.debug("product with id 78 is = {}", pr);
		session1.close();

		pr.setUnitPrice(16.5); // as of now, this "pr" has nothing to do with any "session" object 

		// 2nd session object (brand new session object, with a new cache)
		Session session2 = HibernateUtil.createSession();
		
		
		Transaction tx = session2.beginTransaction();
		try {
			session2.merge(pr); // now "pr" becomes part of session2 cache
			tx.commit(); // "select" and conditionally "update" dirty objects
			log.debug("product price updated!");
		}catch(Exception ex) {
			tx.rollback();
			log.warn("could not update product price", ex);
		}
		session2.close();
	}
}
