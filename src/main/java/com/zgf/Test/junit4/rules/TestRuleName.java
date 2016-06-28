package com.zgf.Test.junit4.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestRuleName {
	@Rule
	public TestName name = new TestName();

	@Test
	public void testA() {
		assertEquals("testA", name.getMethodName());
	}

	@Test
	public void testB() {
		assertEquals("testB", name.getMethodName());
	}
}
