package com.zgf.Test.junit4;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestException {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void empty() {
		new ArrayList<Object>().get(0);
	}

	@Test
	public void testExceptionMessage() {
		try {
			new ArrayList<Object>().get(0);
			System.out.println("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
			MatcherAssert.assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
		}
	}

	// @Test
	// public void shouldThrow() {
	// TestThing testThing = new TestThing();
	// thrown.expect(NotFoundException.class);
	// thrown.expectMessage(startsWith("some Message"));
	// thrown.expect(hasProperty("response", hasProperty("status", is(404))));
	// testThing.chuck();
	// }
}
