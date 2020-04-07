package io.himoura.interview.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionLongestPalindromicSubStringTest {

	@DisplayName("Verify argument passed")
	@Test
	void shouldBlankString() {

		// Given
		final SolutionLongestPalindromicSubString solution = new SolutionLongestPalindromicSubString();

		// When
		String targetEmptyString = solution.longestPalindromic("");
		String targetNullArgument = solution.longestPalindromic(null);

		// Then
		assertAll("Both Null argument and empty string return blank string",
				() -> assertThat(targetEmptyString, emptyString()),
				() -> assertThat(targetNullArgument, emptyString()));
	}

	@DisplayName("Palindrom is present in string")
	@Test
	void shouldLongestPalindromicSubString() {

		// Given
		final SolutionLongestPalindromicSubString solution = new SolutionLongestPalindromicSubString();
		final String givenString = "abcradaruidoelladfdfcllopmlkkayakkopoc";

		// When
		String result = solution.longestPalindromic(givenString);
		String result2 = solution.longestPalindromic("cddaaaaoplkiiiiiiilhhbhb");
		// Then
		assertThat(result, is("kkayakk"));
		assertThat(result2, is("iiiiiii"));
	}

	@DisplayName("Get all substring from any index")
	@Test
	void shouldListSubStringFromAnyIndex() {

		// Given
		final SolutionLongestPalindromicSubString solution = new SolutionLongestPalindromicSubString();
		final String givenString = "abcdef";

		// When
		List<String> result = solution.getAllSubString(givenString);

		// Then
		assertThat(result.size(), is(21));
		assertThat(result, contains("a", "ab", "abc", "abcd", "abcde", "abcdef", "b", "bc", "bcd", "bcde", "bcdef", "c",
				"cd", "cde", "cdef", "d", "de", "def", "e", "ef", "f"));
	}

	@DisplayName("Check is palindrom")
	@Test
	void shouldTrueWhenPalidron() {

		// Given
		final SolutionLongestPalindromicSubString solution = new SolutionLongestPalindromicSubString();
		final String givenString = "aa";

		// When
		boolean resultEvenGiven = solution.isPalindrome(givenString);
		boolean resultOddGiven = solution.isPalindrome("kayak");
		boolean resultNoPalidrom = solution.isPalindrome("aop");

		// Then
		assertAll("Should be palindrom", () -> assertTrue(resultEvenGiven), () -> assertTrue(resultOddGiven));
		assertFalse(resultNoPalidrom);
	}

}
