package io.himoura.interview.leetcode.medium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

class BinaryTreeLevelOrderTraversalTest {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeExpectedResult() {

		// Given
		BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		// When
		List<List<Integer>> result = binaryTreeLevelOrderTraversal.levelOrder(root);

		// Then
		assertThat(result.size(), is(3));
	}
}
