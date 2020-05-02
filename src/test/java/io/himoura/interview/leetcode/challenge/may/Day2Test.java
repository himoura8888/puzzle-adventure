package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day2Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeResult() {

		// Given
		final Day2 day2 = new Day2();

		// When
		int result3 = day2.numJewelsInStones("aA", "aAAbbbb");
		int resultNone = day2.numJewelsInStones("z", "ZZ");

		// Then
		assertThat(result3, is(3));
		assertThat(resultNone, is(0));
	}

}
