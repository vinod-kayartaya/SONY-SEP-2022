package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.LineItem;
import com.sony.utils.HibernateUtil;

public class GetLineItem {
	public static void main(String[] args) {
		
		LineItem li = new LineItem();
		li.setOrderId(10250);
		li.setProductId(51);
		
		Session session = HibernateUtil.createSession();
		li = session.get(LineItem.class, li);
		session.close();
		
		
		System.out.println(li);
		
	}
}
