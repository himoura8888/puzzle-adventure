package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day1Test {

	@DisplayName("LeetCode sample test")
	@Test
	void testName2() {

		// Given
		Day1 day1 = new Day1(4);

		// When
		int result = day1.firstBadVersion(5);

		// Then
		assertThat(result, is(4));
	}

	@DisplayName("Limit test")
	@Test
	void shouldResultBoundValue() {

		// Given
		final Day1 day1First = new Day1(1);
		final Day1 day1Last = new Day1(5);

		// When
		final int resultFirst = day1First.firstBadVersion(5);
		final int resultLast = day1Last.firstBadVersion(5);

		// Then
		assertThat(resultFirst, is(1));
		assertThat(resultLast, is(5));
	}

	@DisplayName("Many version")
	@Test
	void shouldResultLessThan5Second() {

		// Given
		final int firstBadVersion = Integer.MAX_VALUE - 1;
		Day1 day1 = new Day1(firstBadVersion);

		// When

		// Then
		assertTimeout(Duration.ofSeconds(4), () -> {
			day1.firstBadVersion(Integer.MAX_VALUE);
		});
		int result = day1.firstBadVersion(Integer.MAX_VALUE);
		assertThat(result, is(firstBadVersion));
	}

}
