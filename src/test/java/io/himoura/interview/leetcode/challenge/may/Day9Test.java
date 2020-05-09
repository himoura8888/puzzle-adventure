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
		boolean resultExampleError3 = day9.isPerfectSquare(9);

		// Then
		assertThat(resultExample1, is(true));
		assertThat(resultExample2, is(false));
		assertThat(resultExampleError3, is(true));
	}

	@DisplayName("Limit case")
	@Test
	void testName2() {

		// Given
		final Day9 day9 = new Day9();

		// When
		boolean resultExampleError = day9.isPerfectSquare(2147483647);
		boolean resultExampleError2 = day9.isPerfectSquare(1);

		// Then
		assertThat(resultExampleError2, is(true));
		assertThat(resultExampleError, is(false));
	}

}
