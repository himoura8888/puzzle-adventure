package io.himoura.interview.hackerrank.medium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CounterGameTest {

	@DisplayName("HackerRank example")
	@ParameterizedTest
	@CsvSource({ "1073741824, Richard", "1246326493, Richard", "1384145241, Richard", "1649748570, Richard",
			"1628381167, Richard", "1384145241, Richard", "8, Louise", "1459730561, Louise", "1694957143, Louise",
			"2097152, Louise", "2048, Louise", })
	void shouldReturnExpectedResult(long n, String winner) {
		// Given

		// When
		final String result = CounterGame.counterGame(n);

		// Then
		assertThat(result, is(winner));

	}

	@DisplayName("Test package method")
	@Test
	void testName2() {

		// Given
		long powvalues[] = new long[63];
		for (int exp = 0; exp < 63; exp++) {
			powvalues[exp] = 1l << exp;
		}
		// When
		long result1 = CounterGame.getCeilExponent(7, powvalues);
		long result2 = CounterGame.getCeilExponent(64, powvalues);
		long result3 = CounterGame.getCeilExponent(1, powvalues);
		long result4 = CounterGame.getCeilExponent(8, powvalues);

		// Then
		assertThat(result1, is(4l));
		assertThat(result2, is(64l));
		assertThat(result3, is(1l));
		assertThat(result4, is(8l));
	}

}
