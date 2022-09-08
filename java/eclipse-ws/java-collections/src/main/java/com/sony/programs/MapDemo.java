package com.sony.programs;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapDemo {

	public static void main(String[] args) {

		Map<String, String> data = new TreeMap<>();
		data.put("vinod", "vinod@vinod.co");
		data.put("shyam", "shyam@xmpl.com");
		data.put("vinay", "vinay@xmpl.com");
		data.put("vinod", "vinod@gmail.com");
		data.put("naveen", "naveen@xmpl.com");
		data.put("ramesh", "ramesh@xmpl.com");
		data.put("harish", "harish@xmpl.com");
		data.put("rajesh", "rajesh@xmpl.com");

		log.debug("data.size() = {}", data.size());
		log.debug("data = {}", data);

		// a Map can be treated as
		// 1. a set of keys (e.g, names) --> data.keySet()
		// 2. a collection of values (e.g, emails) --> data.values()
		// 3. a set of Entry objects (an Entry is a pair of key and value)

		// 1.
		for (String key : data.keySet()) {
			log.debug("key = {}, value = {}", key, data.get(key));
		}

		// 2.
		for (String value : data.values()) {
			log.debug("value = {}", value);
		}

		// 3.
		Set<Entry<String, String>> es = data.entrySet();
		for (Entry<String, String> e : es) {
			log.debug("key = {}, value = {}", e.getKey(), e.getValue());
		}
	}
}
