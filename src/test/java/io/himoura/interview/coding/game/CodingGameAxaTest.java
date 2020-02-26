package io.himoura.interview.coding.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CodingGameAxaTest {

	@Test
	void test() {
		CodingGameAxa codingGameAxa = new CodingGameAxa();
		assertThat(Integer.valueOf(codingGameAxa.sum(new int[] { 17, 22, 10, 12 })), is(39));
	}

}
