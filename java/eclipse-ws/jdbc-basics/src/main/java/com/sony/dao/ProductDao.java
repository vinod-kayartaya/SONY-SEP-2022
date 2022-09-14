package com.sony.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sony.entity.Product;
import com.sony.utils.DbUtil;

public class ProductDao {
	public Product findById(int id) throws DaoException {
		String sql = "select * from products where product_id = ?";

		try (Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return toProduct(rs);
				}
				
				return null;
			} // rs.close() is done here
		} // stmt and conn are closed here 
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	public List<Product> findAll() throws DaoException {
		List<Product> list = new ArrayList<>();

		String sql = "select * from products";

		try (Connection conn = DbUtil.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while(rs.next()) {
				list.add(toProduct(rs));
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

	Product toProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setProductId(rs.getInt("product_id"));
		p.setProductName(rs.getString("product_name"));
		return p;
	}

	public List<Product> findByPriceRange(double min, double max) throws DaoException {
		List<Product> list = new ArrayList<>();

		String sql = "select * from products where unit_price between ? and ?";

		try (Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					list.add(toProduct(rs));
				}
			} // rs.close() is done here
		} // stmt and conn are closed here 
		catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}
}
