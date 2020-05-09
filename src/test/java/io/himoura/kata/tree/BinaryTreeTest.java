package io.himoura.kata.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Deque;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

class BinaryTreeTest {

	@DisplayName("test")
	@Test
	void shouldDisplay() {

		// Given
		final TreeNode binaryTree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
		final TreeNode binaryTree2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)),
				new TreeNode(3, null, new TreeNode(5)));

		final BinaryTree tree = new BinaryTree();

		// When
		tree.displayTreeNode(binaryTree);
		int numberNode = tree.countTreeNode(binaryTree);
		boolean isNodeHasValue = tree.containsValueIterative(binaryTree, 3);
		boolean isNodeHasValue2 = tree.containsValueRecursive(binaryTree, 3);
//		final TreeNode node3 = day7.getNodeIterative(binaryTree, 4);
		final TreeNode node3Recursive = tree.getNodeRecursive(Optional.of(binaryTree), 3).get();
		final TreeNode parentNode3Recursive = tree.getParentNodeRecursive(Optional.of(binaryTree), 3).get();
		int depth3 = tree.getDepth(binaryTree2);
		final TreeNode tree500 = tree.buildLarge(501);
		final TreeNode treeLarge = tree.buildLarge(10_500_001);

		// Then
		System.out.println("---------------------");
		tree.cpt = 0;
		tree.containsValueRecursive(treeLarge, 450);
		System.out.println(tree.cpt);
		tree.cpt = 0;
		tree.containsValueRecursiveFull(treeLarge, 450);
		System.out.println(tree.cpt);
		System.out.println("---------------------");

		final Deque<TreeNode> pathToNode5 = tree.getPathFromRoot(Optional.of(binaryTree2), 5);
		assertThat(numberNode, is(4));
		assertThat(isNodeHasValue, is(true));
//		assertThat(node3.val, is(4));
		assertThat(node3Recursive.val, is(3));
		assertThat(parentNode3Recursive.val, is(1));
		assertThat(depth3, is(3));
		assertThat(tree.countTreeNode(tree500), is(501));
//		assertThat(tree.maxValue(tree500), is(499));
		assertThat(tree.nodeHighestValue(tree500).get().val, is(499));
		assertThat(tree.countValue(tree500, 17), is(2));
	}

}
