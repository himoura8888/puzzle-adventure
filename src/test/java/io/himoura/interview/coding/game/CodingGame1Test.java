package io.himoura.interview.coding.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CodingGame1Test {

	@DisplayName("Basic sample")
	@Test
	void test() {
		int numbers[] = {1,-28,88,200,7};
		assertThat(CodingGame1.findLargest(numbers), is(200));
		assertThat(CodingGame1.findLargest2(numbers), is(200));
	}
	
	@DisplayName("Bad input")
	@Test
	void testName2() throws Exception {
		
		// Given
		int emptyArray[]= {};

		// When
		// Then
		assertThrows(IllegalArgumentException.class,()->CodingGame1.findLargest(emptyArray));
		assertThrows(IllegalArgumentException.class,()->CodingGame1.findLargest(null));
		assertThrows(IllegalArgumentException.class,()->CodingGame1.findLargest2(emptyArray));
		assertThrows(IllegalArgumentException.class,()->CodingGame1.findLargest2(null));
	}

}
