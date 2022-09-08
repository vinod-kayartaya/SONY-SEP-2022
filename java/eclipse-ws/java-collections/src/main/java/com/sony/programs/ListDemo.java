package com.sony.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListDemo {

	static void workWithList(List<String> names) {
		names.add("Vinod");
		names.add("Shyam");
		names.add("Naveen");
		names.add("Vinod");
		names.add("Kumar");

		log.debug("{}", names);
		log.debug("There are {} names", names.size());
		log.debug("Name at index {} is {}", 2, names.get(2));

		names.add(2, "Vinay");

		log.debug("{}", names);
		log.debug("There are {} names", names.size());
		log.debug("Name at index {} is {}", 2, names.get(2));
		log.debug("Index of Naveen in names is {}", names.indexOf("Naveen"));
		log.debug("names.contains(\"Kumar\") is {}", names.contains("Kumar"));
		
		
		
		List<String> names2 = new ArrayList<>();
		names2.add("Vinod");
		names2.add("Kumar");
		names2.add("Vishal");
		log.debug("names.containsAll(names2) is {}", names.containsAll(names2));
		
//		names.removeAll(names2);
//		log.debug("After removing all names in names2 from names, names is  {}", names);
		names.retainAll(names2);
		log.debug("After retaining all names in names2 from names, names is  {}", names);
		
		log.debug("names.isEmpty() is {}", names.isEmpty());
		names.clear();
		log.debug("names.isEmpty() is {}", names.isEmpty());
		
	}

	public static void main(String[] args) {

		workWithList(new Vector<String>());

	}
}
