package com.sony.programs;

import java.util.ArrayList;
import java.util.List;

import com.sony.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListOfPersonsDemo {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("Vinod", "Kumar", "Bangalore"));
		people.add(new Person("Vinod", "Kumar", "Bangalore"));
		people.add(new Person("Vinod", "Kumar", "Bangalore"));
		people.add(new Person("Naveen", "Kumar", "Chennai"));
		people.add(new Person("Vishal", "Rao", "Mysore"));
		people.add(new Person("Ramesh", "Khanna", "Bhopal"));
		
		log.debug("people.size() = {}", people.size());
		
		for(Person p: people) {
			log.debug("{}", p);
		}
	}
}
