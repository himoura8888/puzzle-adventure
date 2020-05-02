package io.himoura.interview.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

	@DisplayName("Basic test")
	@Test
	void testName2() {

		// Given
		final ReverseString reverse = new ReverseString();

		// When
		final char[] soupCharArray = "soup".toCharArray();
		reverse.reverseString(soupCharArray);

		// Then
		assertThat(soupCharArray, is("puos".toCharArray()));
	}

}
