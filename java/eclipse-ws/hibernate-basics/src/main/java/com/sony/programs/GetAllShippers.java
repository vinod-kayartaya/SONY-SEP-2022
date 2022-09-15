package com.sony.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sony.entity.Shipper;
import com.sony.utils.HibernateUtil;

public class GetAllShippers {
	
	static void printShipper(Shipper shipper) {
		System.out.printf("Id=%d, Name=%s, Phone=%s%n", 
				shipper.getShipperId(),
				shipper.getCompanyName(),
				shipper.getPhone());
	}

	public static void main(String[] args) {

		// sql --> select * from shippers
		// String hql = "select sh from com.sony.entity.Shipper sh";
		// String hql = "from com.sony.entity.Shipper";
		String hql = "from Shipper";
		
		Session session = HibernateUtil.createSession();
		Query<Shipper> qry = session.createQuery(hql, Shipper.class);

		List<Shipper> list = qry.getResultList();
		session.close();

		list.forEach(GetAllShippers::printShipper);
	}
}







