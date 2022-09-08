package com.sony.programs;

import java.util.HashSet;
import java.util.Set;

import com.sony.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetOfPersonsDemo {

	public static void main(String[] args) {

		Set<Person> people = new HashSet<>();
		
		Person p = new Person("Vinod", "Kumar", "Bangalore");
		log.debug("The hashcode of p is {}", p.hashCode());
		people.add(p);
		
		p = new Person("Vinod", "Kumar", "Bangalore");
		log.debug("The hashcode of p is {}", p.hashCode());
		people.add(p);
		
		p = new Person("Vinod", "Kumar", "Bangalore");
		log.debug("The hashcode of p is {}", p.hashCode());
		people.add(p);
		
		people.add(new Person("Naveen", "Kumar", "Chennai"));
		people.add(new Person("Vishal", "Rao", "Mysore"));
		people.add(new Person("Ramesh", "Khanna", "Bhopal"));

		log.debug("people.size() = {}", people.size());

		for (Person p1 : people) {
			log.debug("{}", p1);
		}
	}
}
