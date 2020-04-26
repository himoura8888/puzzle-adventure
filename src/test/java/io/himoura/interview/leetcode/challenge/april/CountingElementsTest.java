package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountingElementsTest {

	@DisplayName("LeetCode test")
	@Test
	void shouldReturnLeetCodeExpectedResult() {
		// Given
		CountingElements countingElements = new CountingElements();

		// When
		int result1 = countingElements.countElements(new int[] { 1, 2, 3 });
		int result2 = countingElements.countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 });
		int result3 = countingElements.countElements(new int[] { 1, 3, 2, 3, 5, 0 });
		int result4 = countingElements.countElements(new int[] { 1, 1, 2, 2 });

		// Then
		assertThat(result1, is(2));
		assertThat(result2, is(0));
		assertThat(result3, is(3));
		assertThat(result4, is(2));

	}

}
