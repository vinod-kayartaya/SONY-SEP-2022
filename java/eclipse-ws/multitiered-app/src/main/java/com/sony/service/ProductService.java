package com.sony.service;

import com.sony.dao.DaoException;
import com.sony.dao.ProductDao;
import com.sony.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductService {

	// We shall visit this code again on Monday to undertand how to do it better!!!
	ProductDao dao = new ProductDao();

	public Iterable<Product> getAllProducts() {
		log.trace("ProductService.getAllProducts() called.");
		return dao.getAllProducts();
	}

	public void addNewProduct(Product product) {
		// do some validations before calling the DAO method
		if (product.getId() <= 0) {
			throw new ServiceException("Product ID cannot be 0 or negative");
		}
		String desc = product.getDescription();

		if (desc == null || desc.trim().length() < 5) {
			throw new ServiceException("Product description must be atleast 5 letters");
		}

		if (product.getPrice() <= 0) {
			throw new ServiceException("Product price must be > 0");
		}

		if (product.getUnitsInStock() < 0) {
			throw new ServiceException("Units in stock for a product must be >= 0");
		}

		try {
			log.trace("calling the dao.add() with product = {}", product);
			dao.add(product);
			log.trace("product {} added successfully", product);
		} catch (DaoException e) {
			log.warn("Error while calling dao.add() method with product = {}", product, e);
			throw new ServiceException(e);
		}
	}

}
