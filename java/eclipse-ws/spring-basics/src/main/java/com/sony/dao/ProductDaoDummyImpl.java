package com.sony.dao;

public class ProductDaoDummyImpl implements ProductDao {
	
	public ProductDaoDummyImpl() {
		System.out.println("ProductDaoDummyImpl instantiated");
	}

	@Override
	public long count() throws DaoException {
		System.out.println("ProductDaoDummyImpl.count() called");
		return 999;
	}

}
