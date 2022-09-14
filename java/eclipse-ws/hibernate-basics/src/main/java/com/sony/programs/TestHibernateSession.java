package com.sony.programs;

import org.hibernate.Session;

import com.sony.entity.Student;
import com.sony.utils.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestHibernateSession {
	public static void main(String[] args) {

		Session session = HibernateUtil.createSession();
		Student st = session.get(Student.class, 1);
		session.close();
		log.debug("student is {}", st);
	}
}
