package io.himoura.interview.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

/**
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * </p>
 * <p>
 * For example: Given binary tree <i>[3,9,20,null,null,15,7]</i></br>
 * <code>
 * &nbsp;3</br>
 * /&nbsp;\</br>
 * 9&nbsp;20</br>
 * &nbsp;&nbsp;/ \</br>
 * &nbsp;&nbsp;15 7</br>
 * </code> return its level order traversal as: </br>
 * <i>[ [3], [9,20], [15,7] ]</i>
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary
 *      Tree Level Order Traversal</a>
 * @version 8 mai 2020
 */
public class BinaryTreeLevelOrderTraversal {
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

			// process node
			// lazy loading

			if (result.size() <= currentLevel) {
				result.add(new ArrayList<>());
			}

			result.get(currentLevel).add(node.val);

			if (!Objects.isNull(node.left)) {
				nodeToTreat.add(node.left);
				countNextLevel++;
			}
			if (!Objects.isNull(node.right)) {
				nodeToTreat.add(node.right);
				countNextLevel++;
			}

			// Event change level
			if (countCurrentLevel == 0) {
				countCurrentLevel = countNextLevel;
				countNextLevel = 0;
				currentLevel++;
			}

		}

		return result;
	}
}
