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
		boolean result1 = day7.isCousins(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), 4,
				3);
		boolean result2 = day7.isCousins(
				new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5))), 5, 4);
		boolean result3 = day7.isCousins(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)), 2,
				3);
		// Then
		assertFalse(result1);
		assertTrue(result2);
		assertFalse(result3);
	}

}
