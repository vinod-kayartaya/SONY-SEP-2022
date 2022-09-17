package com.sony.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sony.dao.ProductDao;
import com.sony.dao.ProductDaoJdbcImpl;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig2 {
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public ProductDao dao() {
		ProductDaoJdbcImpl dao = new ProductDaoJdbcImpl();
		dao.setDriverClassName(driverClassName);
		dao.setUrl(url);
		dao.setUsername(username);
		dao.setPassword(password);
		return dao;
	}
}
