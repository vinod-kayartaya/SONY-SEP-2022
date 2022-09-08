package com.sony.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sony.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDao {

	Map<Integer, Product> map;

	public ProductDao() {
		log.trace("ProductDao constructed");
		// initial values (just for ease of demo)
		map = new LinkedHashMap<>();
		map.put(123, new Product(123, "Logitech optical mouse", 850, 12));
		map.put(198, new Product(198, "Tectron 1TB SSD", 8150, 27));
		map.put(876, new Product(876, "Apple magic mouse", 8500, 7));
		log.trace("3 products added to the map");
	}

	public Iterable<Product> getAllProducts() {
		log.trace("ProductDao.getAllProducts() called");
		return map.values();
	}

	public void add(Product p) {
		if (map.containsKey(p.getId())) {
			throw new DaoException("Product with this ID already exists");
		}
		map.put(p.getId(), p);
	}

}
