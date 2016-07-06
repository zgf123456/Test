package com.zgf.Test.junit4.catagories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestA {
	@Test
	public void a() {
		System.out.println("TestA -> a");
	}

	@Category(SlowTests.class)
	@Test
	public void b() {
		System.out.println("TestA -> b");
	}
}
