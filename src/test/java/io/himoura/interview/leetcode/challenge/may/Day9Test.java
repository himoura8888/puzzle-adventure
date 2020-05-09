package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day9Test {

	@DisplayName("LeetCode Example")
	@Test
	void shouldReturnLeetCode() {

		// Given
		final Day9 day9 = new Day9();

		// When
		boolean resultExample1 = day9.isPerfectSquare(16);
		boolean resultExample2 = day9.isPerfectSquare(14);

		// Then
		assertThat(resultExample1, is(true));
		assertThat(resultExample2, is(false));
	}

}
