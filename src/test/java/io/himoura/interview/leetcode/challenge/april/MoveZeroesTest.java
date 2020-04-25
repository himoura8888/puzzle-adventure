package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveZeroesTest {

	@DisplayName("Base case")
	@Test
	void shouldZeroEndOfArray() {
		// Given
		final MoveZeroes moveZeroes = new MoveZeroes();

		// When
		int[] result = moveZeroes.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
		int[] resultAllZero = moveZeroes.moveZeroes(new int[] { 0, 0, 0, 0, 0 });
		int[] resultNoZero = moveZeroes.moveZeroes(new int[] { 42, 58, 9, 12 });

		// Then
		assertThat(result, is(new int[] { 1, 3, 12, 0, 0 }));
		assertThat(resultAllZero, is(resultAllZero));
		assertThat(resultNoZero, is(resultNoZero));

	}

	@DisplayName("Fail case")
	@Test
	void shouldLeetCodeResult() {
		// Given
		final MoveZeroes moveZeroes = new MoveZeroes();

		// When
		int[] result1 = moveZeroes.moveZeroes(new int[] { 0, 1, 0 });
		int[] result2 = moveZeroes.moveZeroes(new int[] { 0, 0, 1 });

		// Then
		assertThat(result1, is(new int[] { 1, 0, 0 }));
		assertThat(result2, is(new int[] { 1, 0, 0 }));

	}

}
