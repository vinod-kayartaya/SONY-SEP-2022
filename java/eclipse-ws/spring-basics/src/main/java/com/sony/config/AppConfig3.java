package com.sony.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sony.dao.ProductDao;
import com.sony.dao.ProductDaoJdbcImpl;

@Configuration
public class AppConfig3 {
	
	@Bean
	public DataSource ds1() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/northwind");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		return bds;
	}
	
	@Bean
	public DataSource ds2() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/vindb");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		
		bds.setInitialSize(25);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(250);
		bds.setMaxIdle(30);
		
		return bds;
	}

	@Bean
	public ProductDao dao(@Qualifier("ds2") DataSource dataSource) { // Dependency Injection
		
		ProductDaoJdbcImpl jdbcDao = new ProductDaoJdbcImpl();
		jdbcDao.setDataSource(dataSource); // manual wiring
		return jdbcDao;
	}
	
}





