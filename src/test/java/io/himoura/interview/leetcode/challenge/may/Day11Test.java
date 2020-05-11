package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day11Test {

	@DisplayName("LeetCode example Dfs")
	@Test
	void shouldReturnExpectedResult() {
		// Given
		final Day11 day11 = new Day11(new Day11.Dfs());

		// When
		int[][] result1 = day11.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		int[][] result2 = day11.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1);

		// Then
		assertThat(result1, is(new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } }));
		assertThat(result2, is(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }));
	}

	@DisplayName("LeetCode example Bfs")
	@Test
	void shouldReturnExpectedResultBfs() {
		// Given
		final Day11 day11 = new Day11(new Day11.Bfs());

		// When
		int[][] result1 = day11.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		int[][] result2 = day11.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1);

		// Then
		assertThat(result1, is(new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } }));
		assertThat(result2, is(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }));
	}

	@DisplayName("LeetCode example Custom Class and Set")
	@Test
	void shouldReturnExpectedResultCustomClassSet() {
		// Given
		final Day11 day11 = new Day11(new Day11.CustomClassAndSet());

		// When
		int[][] result1 = day11.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		int[][] result2 = day11.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1);

		// Then
		assertThat(result1, is(new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } }));
		assertThat(result2, is(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }));
	}

}
