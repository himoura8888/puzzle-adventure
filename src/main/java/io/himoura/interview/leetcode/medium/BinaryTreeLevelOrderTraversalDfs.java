package io.himoura.interview.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

public class BinaryTreeLevelOrderTraversalDfs implements BinaryTreeLevelOrderTraversalAlgorithm {

	@Override
	public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> result = new LinkedList<>();

		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<List<Integer>> result) {

		class Pair {
			final TreeNode node;
			final int level;

			/**
			 * @param node
			 * @param level
			 */
			public Pair(TreeNode node, int level) {
				this.node = node;
				this.level = level;
			}
		}

		if (root == null)
			return;
		else {
			Deque<Pair> nodesToProcess = new ArrayDeque<>();
			nodesToProcess.add(new Pair(root, 0));
			int height = 0;
			while (!nodesToProcess.isEmpty()) {
				Pair pair = nodesToProcess.pop();
				if (Objects.isNull(pair.node)) {
					continue;
				}
				height = Math.max(height, pair.level);
				nodesToProcess.push(new Pair(pair.node.right, pair.level + 1));
				nodesToProcess.push(new Pair(pair.node.left, pair.level + 1));
				if (result.size() <= pair.level) {
					result.add(new ArrayList<>());
				}
				result.get(pair.level).add(pair.node.val);
			}

		}
	}

}
