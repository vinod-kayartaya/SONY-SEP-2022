package com.sony.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sony.dao.DaoException;
import com.sony.dao.ProductDao;

public class GetProductCount {

	public static void main(String[] args) throws DaoException {
		
		// a variable representing spring container
		ClassPathXmlApplicationContext ctx;
		
		System.out.println("pass-1");
		// an object representing spring container
		ctx = new ClassPathXmlApplicationContext("app-config.xml");
		// creates instances of all (non-lazy) singleton beans in the xml
		// and keeps them in the container, identifiable by their id or name
		System.out.println("pass-2");
		// interface variable as dependency
		ProductDao dao;
		
		// dependency as tight coupling
		// dao = new ProductDaoDummyImpl();
		
		// loose coupling
		dao = ctx.getBean("dummy", ProductDao.class);
		ProductDao dao1 = ctx.getBean("dummy", ProductDao.class);
		
		System.out.println("dao==dao1 is " + (dao==dao1));
		
		System.out.println("pass-3"); 
		ProductDao dao2 = ctx.getBean("jdbc", ProductDao.class); // created once
		System.out.println("pass-4"); 
		ProductDao dao3 = ctx.getBean("jdbc", ProductDao.class); // used again
		System.out.println("pass-5");
		System.out.println("da2==dao3 is " + (dao2==dao3));
		
		// using the dependency..
		long pc = dao2.count();
		System.out.println("There are " + pc + " products");
		
		// closing the spring container; releases all resources.
		ctx.close();
		
	}
}
