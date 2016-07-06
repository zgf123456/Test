package com.zgf.Test.junit4.catagories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ SlowTests.class, FastTests.class })
public class TestB {

	@Test
	public void a() {
		System.out.println("TestB -> a");
	}
	
	@Category(FastTests.class)
	@Test
	public void b() {
		System.out.println("TestB -> b");
	}
}
