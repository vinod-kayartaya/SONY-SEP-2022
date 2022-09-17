package com.sony.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sony.config.AppConfig4;
import com.sony.dao.DaoException;
import com.sony.dao.ProductDao;

public class PrintProductCount {

	public static void main(String[] args) throws DaoException {

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

		ProductDao dao = ctx.getBean(ProductDao.class);

		long pc = dao.count();
		System.out.println("There are " + pc + " products");

		ctx.close();

	}
}
