package com.zgf.Test.java8.stream;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseTest {
	public static void main(String[] args) {
		Long collect1 = Stream.of("a", "b", "c").collect(Collectors.counting());
		String collect2 = Stream.of("a", "b", "c").collect(Collectors.joining(","));
		System.out.println(collect1);
		System.out.println(collect2);
	}
}
