package com.zgf.Test.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestRuleErrorCollector {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void example() {
		System.out.println("test errorcollector start");
		collector.addError(new Throwable("first thing went wrong"));
		collector.addError(new Throwable("second thing went wrong"));
		System.out.println("test errorcollector end");
	}
}
