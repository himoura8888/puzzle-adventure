package io.himoura.interview.coding.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CodingGame2Test {
	
	@DisplayName("Graphical representation of character included in range A to Z")
	@Test
	void testCorrectInput() {
		assertThat(CodingGame2.scanChar("A-A"), is('A'));
		assertThat(CodingGame2.scanChar("G-G"), is('G'));
		assertThat(CodingGame2.scanChar("P-P"), is('P'));
	}
	@DisplayName("Graphical representation of character excluded from range A to Z")
	@Test
	void testIncorrectInput() {
		assertThat(CodingGame2.scanChar("P-T"), is('?'));
	}

}
