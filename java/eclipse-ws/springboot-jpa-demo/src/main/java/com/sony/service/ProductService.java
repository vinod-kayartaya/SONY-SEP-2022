package com.sony.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sony.entity.Product;
import com.sony.repository.ProductRepository;

@Service
public class ProductService {

	// Springboot creates a class that implements
	// ProductRepository on the fly and injects
	// an object of the same here
	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProducts(Integer pageNum, Integer pageSize, String sortBy) {

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by(sortBy));

		return repo.findAll(pageable).getContent();
	}

	public Product getProductById(Integer id) {
		Optional<Product> op = repo.findById(id);
		return op.isEmpty() ? null : op.get();
	}

	public Product addNewProduct(Product product) {
		product.setId(null);
		return repo.save(product);
	}

	public Product updateProduct(Integer id, Product product) {
		product.setId(id);
		return repo.save(product);
	}

	public Product patchProduct(Integer id, Product p2) {
		Product p1 = this.getProductById(id);
		if (p1 != null) {
			if (p2.getName() != null) {
				p1.setName(p2.getName());
			}
			if (p2.getQuantityPerUnit() != null) {
				p1.setQuantityPerUnit(p2.getQuantityPerUnit());
			}
			if (p2.getUnitPrice() != null) {
				p1.setUnitPrice(p2.getUnitPrice());
			}
			if (p2.getUnitsInStock() != null) {
				p1.setUnitsInStock(p2.getUnitsInStock());
			}
			if (p2.getUnitsOnOrder() != null) {
				p1.setUnitsOnOrder(p2.getUnitsOnOrder());
			}
			if (p2.getReorderLevel() != null) {
				p1.setReorderLevel(p2.getReorderLevel());
			}
			if (p2.getDiscontinued() != null) {
				p1.setDiscontinued(p2.getDiscontinued());
			}
			if (p2.getCategoryId() != null) {
				p1.setCategoryId(p2.getCategoryId());
			}
			if (p2.getSupplierId() != null) {
				p1.setSupplierId(p2.getSupplierId());
			}
			repo.save(p1);
			return p1;
		}

		return null;
	}

}
