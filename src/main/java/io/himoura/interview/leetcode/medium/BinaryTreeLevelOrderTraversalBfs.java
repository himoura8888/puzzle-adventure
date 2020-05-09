package io.himoura.interview.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

class BinaryTreeLevelOrderTraversalBfs implements BinaryTreeLevelOrderTraversalAlgorithm {

	@Override
	public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> result = new ArrayList<>();
		if (Objects.isNull(root))
			return result;

		final Deque<TreeNode> nodeToTreat = new ArrayDeque<>();
		nodeToTreat.add(root);
		int currentLevel = 0;
		int countCurrentLevel = 1;
		int countNextLevel = 0;
		while (!nodeToTreat.isEmpty()) {
			TreeNode node = nodeToTreat.poll();
			countCurrentLevel--;

			// lazy loading
			if (result.size() <= currentLevel) {
				result.add(new ArrayList<>());
			}
			// process node
			result.get(currentLevel).add(node.val);

			// process children
			if (!Objects.isNull(node.left)) {
				nodeToTreat.add(node.left);
				countNextLevel++;
			}
			if (!Objects.isNull(node.right)) {
				nodeToTreat.add(node.right);
				countNextLevel++;
			}

			// Detect change level
			if (countCurrentLevel == 0) {
				countCurrentLevel = countNextLevel;
				countNextLevel = 0;
				currentLevel++;
			}

		}

		return result;
	}
}
