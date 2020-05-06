package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day6Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnExample() {
		// Given
		final Day6 day6 = new Day6();

		// When
		int result1 = day6.majorityElement(new int[] { 3, 2, 3 });
		int result2 = day6.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 });

		// Then
		assertThat(result1, is(3));
		assertThat(result2, is(2));
	}

}
