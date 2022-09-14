package com.sony.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sony.entity.Category;
import com.sony.entity.Product;

public class HibernateUtil {
	public static Session createSession() {
		Configuration cfg = new Configuration(); // db configuration
		cfg.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/vindb");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "Welcome#123");
		cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.format_sql", "true");

		cfg.addAnnotatedClass(Product.class);
		cfg.addAnnotatedClass(Category.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}
