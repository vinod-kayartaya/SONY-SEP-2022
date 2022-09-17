package com.sony.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

// @Component
// @Service --> Service or business logic layer/tier
// @Repository --> DAO or Repository layer
// @Controller, @RestController --> Web tier
// @Configuration --> application configuration
@Repository("dao")
@Setter
public class ProductDaoJdbcImpl implements ProductDao {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	// database connection pool
	@Autowired
	private DataSource dataSource;

	public ProductDaoJdbcImpl() {
		System.out.println("ProductDaoJdbcImpl instantiated");
	}

	private Connection getConnection() throws DaoException {

		try {

			if (this.dataSource != null) {
				return this.dataSource.getConnection();
			}

			Class.forName(driverClassName);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public long count() throws DaoException {
		System.out.println("ProductDaoJdbcImpl.count() called");

		try (Connection conn = this.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from PRODUCTS");) {

			rs.next();
			return rs.getLong(1);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

}
