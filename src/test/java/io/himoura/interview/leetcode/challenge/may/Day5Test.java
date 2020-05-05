package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day5Test {

	@DisplayName("LeetCode Example")
	@Test
	void shouldReturnLeetCodeExpectedResult() {
		// Given
		final Day5 day5 = new Day5();
		// When
		int resultL = day5.firstUniqChar("leetcode");
		int resultV = day5.firstUniqChar("loveleetcode");
		// Then
		assertThat(resultL, is(0));
		assertThat(resultV, is(2));
	}

	@DisplayName("Only Repeating Character")
	@Test
	void shouldReturnPersonalExpectedResult() {
		// Given
		final Day5 day5 = new Day5();
		// When
		int resultDefaultValue = day5.firstUniqChar("aabbcc");
		// Then
		assertThat(resultDefaultValue, is(-1));
	}

	@DisplayName("Special input value")
	@Test
	void shouldReturnDefaultValue() {
		// Given
		final Day5 day5 = new Day5();
		// When
		int resultDefaultValue = day5.firstUniqChar("");
		int resultDefaultValue2 = day5.firstUniqChar(null);
		// Then
		assertThat(resultDefaultValue, is(-1));
		assertThat(resultDefaultValue2, is(-1));
	}

}
