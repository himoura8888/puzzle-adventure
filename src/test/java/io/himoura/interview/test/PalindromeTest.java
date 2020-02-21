package io.himoura.interview.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PalindromeTest {
	
	@DisplayName("Should be palindrome")
	@Test
	void shouldBePalindrome() {
		assertTrue(Palindrome.isPalindrom("radxdar"));
		assertTrue(Palindrome.isPalindrom("alla"));
	}
	
	@DisplayName("Shouldn't be palindrome")
	@Test
	void shouldNotPalindrome() {
		assertFalse(Palindrome.isPalindrom("panda"));
		assertFalse(Palindrome.isPalindrom("tiger"));
	}

}
