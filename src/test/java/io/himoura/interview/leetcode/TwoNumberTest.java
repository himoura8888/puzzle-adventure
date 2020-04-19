package io.himoura.interview.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoNumberTest {

	@DisplayName("Base case")
	@Test
	void testName2() {
		final TwoNumber solution = new TwoNumber();

		// Given

		// When
		final int[] resultat = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);

		// Then
		assertThat(resultat, is(new int[] { 0, 1 }));
	}

	@DisplayName("Error result")
	@Test
	void todebug() {
		final TwoNumber solution = new TwoNumber();

		// Given

		// When
		final int[] resultat = solution.twoSum(new int[] { 3, 2, 4 }, 6);

		// Then
		assertThat(resultat, is(new int[] { 1, 2 }));
	}

}
