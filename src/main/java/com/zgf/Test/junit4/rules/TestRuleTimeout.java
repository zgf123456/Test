package com.zgf.Test.junit4.rules;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class TestRuleTimeout {
	public static String log;

	@Rule
	public TestRule globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

	@Test
	public void testInfiniteLoop1() {
		log += "ran1";
		for (;;) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testInfiniteLoop2() {
		log += "ran2";
		for (;;) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
