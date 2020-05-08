package io.himoura.interview.leetcode.challenge.may;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day8Test {

	@DisplayName("LeetCode Example")
	@Test
	void shouldReturnLeetCodeExpectedResult() {

		// Given
		final Day8 day8 = new Day8();
		// When
		boolean resultExample1 = day8
				.checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } });
		boolean resultExample2 = day8
				.checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } });

		// Then
		assertTrue(resultExample1);
		assertFalse(resultExample2);
	}

}
