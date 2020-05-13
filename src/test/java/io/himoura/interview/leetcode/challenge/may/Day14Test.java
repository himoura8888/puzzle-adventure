package io.himoura.interview.leetcode.challenge.may;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day14Test {

	@DisplayName("LeetCode example")
	@Test
	void testName2() {

		Trie trie = new Trie();

		trie.insert("apple");
		// Given

		// When
		boolean resultSearchElementExist = trie.search("apple");
		boolean resultStrictlySearch = trie.search("app");
		boolean resultSearchStartWith = trie.startsWith("app");
		trie.insert("app");
		boolean resultStrictlySearch2 = trie.search("app");

		// Then
		assertTrue(resultSearchElementExist);
		assertFalse(resultStrictlySearch);
		assertTrue(resultSearchStartWith);
		assertTrue(resultStrictlySearch2);
	}

	@DisplayName("Edge case")
	@Test
	void shouldReturnSpecialValue() {

		Trie trie = new Trie();
		// Given

		// When
		boolean resultSearchEmptyTrie = trie.search("addd");
		boolean resultStartsWithEmptyTrie = trie.startsWith("addd");

		// Then
		assertFalse(resultSearchEmptyTrie);
		assertFalse(resultStartsWithEmptyTrie);
	}

	@DisplayName("Error case")
	@Test
	void shouldReturnExpectedResult() {

		// Given
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.insert("beer");
		trie.insert("add");
		trie.insert("jam");
		trie.insert("rental");
		trie.insert("apps");
		trie.displayByLevel();
		// When
		boolean resultSearchWordInserted = trie.search("apps");
		boolean resultStartWithWordInserted = trie.startsWith("apps");

		// Then
		assertTrue(resultSearchWordInserted);
		assertTrue(resultStartWithWordInserted);
	}

}
