package com.sony.programs;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sony.entity.Product;
import com.sony.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AddNewProduct {
	public static void main(String[] args) {
		Product p = new Product();
		p.setProductId(78);
		p.setProductName("Pepsi");
		p.setQuantityPerUnit("10 bottles x 2 box");
		p.setUnitPrice(18.0);
		p.setUnitsInStock(12);
		p.setDiscontinued(false);
		p.setUnitsOnOrder(7);
		p.setReorderLevel(2);
		// p.setCategoryId(1);
		p.setSupplierId(1);
		
		Session session = HibernateUtil.createSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(p);
			tx.commit();
			log.debug("product {} added to the database table", p);
		} catch (Exception e) {
			tx.rollback();
			log.warn("could not add product {} to the database table", p, e);
		}
		session.close();
	}
}







