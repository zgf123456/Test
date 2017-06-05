package com.zgf.Test.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicTest {
	public static void main(String[] args) {
//		Predicate<Integer> predicate = x -> x > 5;
		List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
		strings.forEach((s) -> System.out.println(s));

		Collections.sort(strings, (String s1, String s2) -> s2.compareTo(s1));
		System.out.println(strings);
		Collections.sort(strings, (s1, s2) -> s1.compareTo(s2));
		System.out.println(strings);
		strings.sort((s1, s2) -> s2.compareTo(s1));
		System.out.println(strings);

		new Thread(() -> {
			System.out.println("test");
		}).start();

	}
}
