package com.sony.programs;

import java.util.Set;
import java.util.TreeSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetDemo {

	public static void main(String[] args) {
		
		Set<Integer> nums = new TreeSet<>();
		nums.add(123);
		nums.add(222);
		nums.add(34);
		nums.add(3333);
		nums.add(-456);
		nums.add(222);
		nums.add(34);
		nums.add(34);
		nums.add(45);
		
		log.debug("nums.size() = {}", nums.size());
		log.debug("nums = {}", nums);
		
	}
}
