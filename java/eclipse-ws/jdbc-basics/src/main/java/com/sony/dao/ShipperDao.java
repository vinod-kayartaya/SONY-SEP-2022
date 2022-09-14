package com.sony.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sony.entity.Shipper;
import com.sony.utils.DbUtil;

public class ShipperDao {
	public List<Shipper> findAll() throws DaoException {
		List<Shipper> shippers = new ArrayList<>();

		try (Connection conn = DbUtil.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from shippers");) {
			
			while(rs.next()) {
				Shipper s = new Shipper();
				s.setShipperId(rs.getInt(1));
				s.setCompanyName(rs.getString(2));
				s.setPhone(rs.getString(3));
				shippers.add(s);
			}
		} catch (Exception ex) {
			throw new DaoException(ex); // convert any exception to DaoException
		}

		return shippers;
	}
}
