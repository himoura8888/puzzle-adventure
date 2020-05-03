package io.himoura.interview.leetcode.challenge.may;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day3Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeExpectedResult() {

		// Given
		final Day3 day4 = new Day3();

		// When
		boolean resultFalse = day4.canConstruct("a", "b");
		boolean resultTrue = day4.canConstruct("aa", "aab");
		boolean resultTrue1 = day4.canConstruct("", "1");
		boolean resultTrue2 = day4.canConstruct("", "");

		// Then
		assertTrue(resultTrue);
		assertTrue(resultTrue1);
		assertTrue(resultTrue2);
		assertFalse(resultFalse);
	}

	@DisplayName("Personal example")
	@Test
	void shouldReturnExpectedResult() {

		// Given
		final Day3 day4 = new Day3();

		// When
		boolean resultFalse = day4.canConstruct("arre", "oplaer");

		// Then
		assertFalse(resultFalse);
	}

}
