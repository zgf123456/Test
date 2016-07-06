package com.zgf.Test.junit4;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestTheroyAndTestFixtures {
	// @DataPoint
	// public static String GOOD_USERNAME = "optimus";
	// @DataPoint
	// public static String USERNAME_WITH_SLASH = "optimus/prime";
	//
	// @Theory
	// public void filenameIncludesUsername(String username) {
	// System.out.println(username);
	// // assumeThat(username, not(containsString("/")));
	// // assertThat(new User(username).configFileName(),
	// // containsString(username));
	// }

	@DataPoints
	public static int[] positiveIntegers() {
		return new int[] { 1, 10, 1234567 };
	}

	@DataPoint
	public static int testInt = 333;

	@Theory
	public void a_plus_b_is_greater_than_a_and_greater_than_b(Integer a, Integer b) {
		System.out.println("----" + a + "," + b);
		assertTrue(a + b > a);
		assertTrue(a + b > b);
	}

	@Theory
	public void greaterThan0(@TestedOn(ints = { 1, 2, 3, 4 }) Integer a) {
		System.out.println(">>>>" + a);
		assertTrue(a > 0);
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}
}
