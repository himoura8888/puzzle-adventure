package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaximumArrayTest {

	@DisplayName("Base case")
	@Test
	void shouldReturnMaxSumOfSubArray() {
		// Given
		final MaximumArray maximumArray = new MaximumArray();
		// When
		int result = maximumArray.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });

		// Then
		assertThat(result, is(6));
	}

	@DisplayName("Array has one element")
	@Test
	void shouldReturnElementy() {
		// Given
		final MaximumArray maximumArray = new MaximumArray();
		// When
		int result = maximumArray.maxSubArray(new int[] { 1 });

		// Then
		assertThat(result, is(1));
	}

}
