package com.zgf.Test.junit4;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestTheories2 {
	@DataPoint
	public static int testInt = 333;
	
	@Theory
	public void greaterThan0(Integer a) {
		System.out.println(">>>>" + a);
		assertTrue(a > 0);
	}
}
