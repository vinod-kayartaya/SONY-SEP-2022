package com.sony.programs;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sony.entity.Product;
import com.sony.utils.HibernateUtil;

public class TestHibernateQueryLanguage {

	static Session session;

	public static void main(String[] args) {
		session = HibernateUtil.createSession();

		// printProductsBetweenPrice(50.0, 500.0);
		// printProductsByPage(3, 15); // pageNum = 3, pageSize=10
		printProductsByCategory("Condiments"); // categoryName = "Condiments"

		session.close();
	}

	 static void printProductsByCategory(String categoryName) {
		 String hql = "from Product p where p.category.categoryName = :CAT_NAME";
		 Query<Product> qry = session.createQuery(hql, Product.class);
		 qry.setParameter("CAT_NAME", categoryName);
		 qry.getResultList().forEach(
				 p -> System.out.printf(
						 "%s --> %s%n", p.getProductName(), p.getCategory().getCategoryName()));
	}

	static void printProductsByPage(int pageNum, int pageSize) {
		String hql ="from Product order by productId";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setMaxResults(pageSize);
		qry.setFirstResult((pageNum-1)*pageSize);
		qry.getResultList().forEach(
				p -> System.out.printf(
						"%2d) %s --> %.2f%n", 
						p.getProductId(),
						p.getProductName(), 
						p.getUnitPrice()));

	}

	static void printProductsBetweenPrice(double min, double max) {
		// String hql = "from Product where unitPrice between ?1 and ?2";
		String hql = "from Product where unitPrice between :MIN and :MAX";
		Query<Product> qry = session.createQuery(hql, Product.class);

		// qry.setParameter(1, min);
		// qry.setParameter(2, max);
		qry.setParameter("MIN", min);
		qry.setParameter("MAX", max);

		qry.getResultList().forEach(p -> System.out.printf("%s --> %.2f%n", p.getProductName(), p.getUnitPrice()));
	}

}
