package com.sony.programs;

import com.sony.entity.Student;

public class InheritanceDemo {


	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setFirstname("Rohit");
		s1.setLastname("Sharma");
		s1.setAge(22);
		s1.setHeight(5.9);
		s1.setWeight(67);
		s1.getAddress().setCity("Chennai");
		s1.getAddress().setCountry("India");
		s1.setGpa(4.7);
		s1.setMajorSubject("Python");
		s1.setSemister(3);
		
		System.out.println(s1);
		
	}
}
