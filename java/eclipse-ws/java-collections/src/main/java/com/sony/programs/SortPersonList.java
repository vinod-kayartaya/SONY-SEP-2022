package com.sony.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sony.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortPersonList {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Vinod", "Kumar", "Bangalore"));
		people.add(new Person("Avinash", "Singh", "Delhi"));
		people.add(new Person("Amar", "Gupta", "Mumbai"));
		people.add(new Person("Naveen", "Srinivas", "Chennai"));
		people.add(new Person("Vishal", "Rao", "Mysore"));
		people.add(new Person("Ramesh", "Khanna", "Bhopal"));

		List<String> names = Arrays.asList("Vinod", "Avinash", "Amar", "Naveen", "Vishal", "Ramesh");
		log.debug("{}", names);

		Collections.sort(names);
		log.debug("{}", names);
		Collections.reverse(names);
		log.debug("{}", names);

		// people is a collection of non-comparable objects
		// So, we can supply the logic for comparing two persons as Comparator<Person>
		// object

		Comparator<Person> cmp = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getFirstname().compareTo(p2.getFirstname());
			}
		};

		// the Collections.sort() knows how to sort objects, but doesn't know how to
		// compare two person objects,
		// which is required for sorting. That logic for finding the order between two
		// person objects is
		// provided by the "cmp" (an object of Comparator<Person>)
		Collections.sort(people, cmp);

		log.debug("After sorting people by firstname: ");
		for (Person pr : people) {
			log.debug("{}", pr);
		}

		// Arrow functions (p1, p2)->{}
		// Can be used as a substitution for anonymous objects representing object an
		// interface with exactly one abstract method (a.k.a. functional interface)
		Collections.sort(people, (p1, p2) -> p1.getLastname().compareTo(p2.getLastname()));
		log.debug("After sorting people by lastname: ");
		for (Person pr : people) {
			log.debug("{}", pr);
		}
		

		Collections.sort(people, (p1, p2) -> p1.getCity().compareTo(p2.getCity()));
		log.debug("After sorting people by lastname: ");
		for (Person pr : people) {
			log.debug("{}", pr);
		}
	}
}
