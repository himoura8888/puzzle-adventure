package io.himoura.interview.leetcode.challenge.may;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day7Test {

	@DisplayName("LeetCode Example")
	@Test
	void shouldReturnLeetCodeResult() {

		// Given
		Day7 day7 = new Day7();
		// When
		boolean result1 = day7.isCousins(new TreeNode(), 4, 3);
		boolean result2 = day7.isCousins(new TreeNode(), 5, 4);
		boolean result3 = day7.isCousins(new TreeNode(), 2, 3);

		// Then
		assertFalse(result1);
		assertTrue(result2);
		assertFalse(result3);

	}

}
