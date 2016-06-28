package com.zgf.Test.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class TestRuleExternalResource {
	@Rule
	public ExternalResource externalResource = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			System.out.println("before");
		};

		@Override
		protected void after() {
			System.out.println("after test");
		};
	};

	@Test
	public void testExternalResource() {
		System.out.println("do testing");
	}
}
