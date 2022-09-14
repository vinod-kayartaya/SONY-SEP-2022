package com.sony.programs;

import java.util.List;

import com.sony.dao.DaoException;
import com.sony.dao.ShipperDao;
import com.sony.entity.Shipper;

public class CheckShipperDaoMethods {

	public static void main(String[] args) {

		ShipperDao dao = new ShipperDao();

		try {
			List<Shipper> list = dao.findAll();

			list
				.stream()
				.map(sh -> sh.getCompanyName())
				.forEach(System.out::println);

		} catch (DaoException e) {
			System.err.println("There was an error: " + e.getMessage());
		}

	}
}
