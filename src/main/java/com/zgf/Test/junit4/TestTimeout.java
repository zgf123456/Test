package com.zgf.Test.junit4;

import org.junit.Test;

public class TestTimeout {
	@Test(timeout = 100)
	public void testWithTimeout() {
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
