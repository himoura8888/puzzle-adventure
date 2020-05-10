package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day10Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnExpectedResult() {

		// Given
		final Day10 day10 = new Day10();

		// When
		int result1 = day10.findJudge(2, new int[][] { { 1, 2 } });
		int result2 = day10.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } });
		int result3 = day10.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } });
		int result4 = day10.findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } });
		int result5 = day10.findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } });

		// Then
		assertThat(result1, is(2));
		assertThat(result2, is(3));
		assertThat(result3, is(-1));
		assertThat(result4, is(-1));
		assertThat(result5, is(3));
	}

}
