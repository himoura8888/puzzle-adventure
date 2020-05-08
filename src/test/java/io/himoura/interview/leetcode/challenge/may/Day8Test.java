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
		boolean resultHorizontal = day8
				.checkStraightLine(new int[][] { { -3, -2 }, { -1, -2 }, { 2, -2 }, { -2, -2 }, { 0, -2 } });
		boolean resultVertical = day8
				.checkStraightLine(new int[][] { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } });

		boolean resulError = day8.checkStraightLine(new int[][] { { 0, 1 }, { 1, 3 }, { -4, -7 }, { 5, 11 } });
		boolean resulError2 = day8.checkStraightLine(
				new int[][] { { 2, -3 }, { -8, -3 }, { -8, 6 }, { -4, 8 }, { 1, 5 }, { 4, -7 }, { 1, 7 }, { 8, 4 } });

		// Then
		assertTrue(resultExample1);
		assertFalse(resultExample2);
		assertTrue(resultVertical);
		assertTrue(resultHorizontal);
		assertTrue(resulError);
		assertFalse(resulError2);
	}

}
