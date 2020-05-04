package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day4Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeResult() {

		// Given
		final Day4 day4 = new Day4();

		// When
		int result2 = day4.findComplement(5);
		int result0 = day4.findComplement(1);

		// Then
		assertThat(result2, is(2));
		assertThat(result0, is(0));

	}

	@DisplayName("Personal example")
	@Test
	void shouldReturnPersonalResult() {

		// Given
		final Day4 day4 = new Day4();

		// When
		int result1 = day4.findComplement(0);
		int resultMax = day4.findComplement(Integer.MAX_VALUE);

		// Then
		assertThat(resultMax, is(0));
		assertThat(result1, is(0));

	}

}
