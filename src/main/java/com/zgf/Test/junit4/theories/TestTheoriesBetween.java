package com.zgf.Test.junit4.theories;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestTheoriesBetween {

	@Theory
	public void greaterThan0(@Between(first = 100, last = 200) Integer a) {
		System.out.println(">>>>" + a);
		assertTrue(a > 0);
	}
}
