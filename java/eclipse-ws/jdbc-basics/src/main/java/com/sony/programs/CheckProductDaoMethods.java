package com.sony.programs;

import java.util.List;

import com.sony.dao.DaoException;
import com.sony.dao.ProductDao;
import com.sony.entity.Product;

public class CheckProductDaoMethods {

	public static void main(String[] args) throws DaoException {
		ProductDao dao = new ProductDao();
		
//		Product pr = dao.findById(12);
//		System.out.println(pr);
		
//		List<Product> list = dao.findAll();
//		list.forEach(System.out::println);
		
		List<Product> list = dao.findByPriceRange(50, 500);
		list.forEach(System.out::println);
	}

}
