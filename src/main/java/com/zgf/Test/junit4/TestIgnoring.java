package com.zgf.Test.junit4;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.MatcherAssert;

public class TestIgnoring {
	@Ignore("Test is ignored as a demonstration")
	@Test
	public void testSame() {
		MatcherAssert.assertThat(1, is(1));
	}
}
