package io.himoura.interview.coding.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class CodingGame4Test {

	@Test
	void testCheck() {
		assertTrue(CodingGame4.check("[()]"));
		assertTrue(CodingGame4.check("(()[])"));
		assertFalse(CodingGame4.check("([)]"));
		assertFalse(CodingGame4.check("(("));
		assertFalse(CodingGame4.check("[(()])"));
		assertFalse(CodingGame4.check("))))"));
		assertFalse(CodingGame4.check("(([["));
		
		assertTrue(CodingGame4.check("([(([[(([]))]]))])"));
		final String str = "[](()()[[]])()[]([])";
		assertTrue(CodingGame4.check(str));
		assertFalse(CodingGame4.check("[](()()[[]])[][[([])"));
		assertFalse(CodingGame4.check("([((([(([]))])))))])"));
		assertTrue(CodingGame4.check(Stream.generate(()->str).limit(500).collect(Collectors.joining())));
	}

}
