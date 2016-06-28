package com.zgf.Test.junit4.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;

public class TestRuleChain {
	@Rule
	public TestRule chain = RuleChain.outerRule(new TestName());

	@Test
	public void example() {
		assertTrue(true);
	}
}
