package com.zgf.Test.junit4.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class TestRuleVerifier {
	private static String sequence;
	@Rule
	public Verifier collector = new Verifier() {
		@Override
		protected void verify() {
			sequence += "verify ";
		}
	};

	@Test
	public void example() {
		sequence += "test ";
	}

	@Test
	public void verifierRunsAfterTest() {
		sequence = "";
//		assertThat((TestResultUsesVerifier.class), isSuccessful());
		assertEquals("test verify ", sequence);
	}

}
