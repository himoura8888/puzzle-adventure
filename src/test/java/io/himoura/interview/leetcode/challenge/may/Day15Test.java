package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day15Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeResult() {

		// Given
		final Day15 day15 = new Day15();

		// When
		final int result1 = day15.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 });
		final int result2 = day15.maxSubarraySumCircular(new int[] { 5, -3, 5 });
		final int result3 = day15.maxSubarraySumCircular(new int[] { 3, -1, 2, -1 });
		final int result4 = day15.maxSubarraySumCircular(new int[] { 3, -2, 2, -3 });
		final int result5 = day15.maxSubarraySumCircular(new int[] { -2, -3, -1 });

		// Then
		assertThat(result1, is(3));
		assertThat(result2, is(10));
		assertThat(result3, is(4));
		assertThat(result4, is(3));
		assertThat(result5, is(-1));
	}

}
