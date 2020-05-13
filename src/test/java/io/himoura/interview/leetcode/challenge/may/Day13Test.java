package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day13Test {

	@DisplayName("LeetCode Example")
	@Test
	void testName2() {

		// Given
		final Day13 day13 = new Day13();

		// When
		final String result1 = day13.removeKdigits("1432219", 2);
		final String result2 = day13.removeKdigits("10200", 1);
		final String result3 = day13.removeKdigits("10", 2);
		final String resultZero = day13.removeKdigits("10", 1);
		final String resultZero2 = day13.removeKdigits("100", 1);
		final String resultError = day13.removeKdigits("112", 1);
		// Then

		assertThat(result1, is("12219"));
		assertThat(result2, is("200"));
		assertThat(result3, is("0"));
		assertThat(resultZero, is("0"));
		assertThat(resultZero2, is("0"));
		assertThat(resultError, is("11"));
	}

}
