package com.sony.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sony.dao.ProductDao;
import com.sony.dao.ProductDaoDummyImpl;
import com.sony.dao.ProductDaoJdbcImpl;

// This class is equivalent to the app-config.xml
@Configuration
public class AppConfig1 {

	public AppConfig1() {
		System.out.println("AppConfig1 instantiated!");
	}

	// this method is equivalent of a <bean> definition in the xml file
	// this function must return an object, which then will be kept
	// in the spring container
	@Bean
	@Scope("singleton")
	public ProductDao jdbcProductDao() {
		System.out.println("AppConfig1.jdbcProductDao() called");

		ProductDaoJdbcImpl dao = new ProductDaoJdbcImpl();
		dao.setDriverClassName("org.h2.Driver");
		dao.setUrl("jdbc:h2:tcp://localhost/~/vindb");
		dao.setUsername("root");
		dao.setPassword("Welcome#123");
		return dao;
	}
}
