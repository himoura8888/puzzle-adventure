package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day12Test {

	@DisplayName("LeetCode example")
	@Test
	void testName2() {

		// Given
		Day12 day12 = new Day12();

		// When
		int result1 = day12.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 });
		int result2 = day12.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 });
		int resultSingleAtFirst = day12.singleNonDuplicate(new int[] { 2, 3, 3, 7, 7, 10, 10, 11, 11 });
		int resultSingleElement = day12.singleNonDuplicate(new int[] { 42 });

		// Then
		assertThat(result1, is(2));
		assertThat(result2, is(10));
		assertThat(resultSingleAtFirst, is(2));
		assertThat(resultSingleElement, is(42));
	}

}
