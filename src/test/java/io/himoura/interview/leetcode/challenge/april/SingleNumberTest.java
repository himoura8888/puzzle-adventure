package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingleNumberTest {

	private static SingleNumber solution;

	@BeforeAll
	static void setup() {
		solution = new SingleNumber();
	}

	@DisplayName("Bad parameter")
	@Test
	void shouldExceptionThrown() {
		// Given, When, Then
		assertThrows(IllegalArgumentException.class, () -> solution.singleNumber(new int[] {}));
		assertThrows(IllegalArgumentException.class, () -> solution.singleNumber(null));
	}

	@DisplayName("Base case")
	@Test
	void shouldSingleIndexOfArray() {
		// Given, When
		int result1 = solution.singleNumber(new int[] { 2, 2, 1 });
		int result2 = solution.singleNumber(new int[] { 4, 1, 2, 1, 2 });

		// Then
		assertThat(result1, is(1));
		assertThat(result2, is(4));
	}

}
