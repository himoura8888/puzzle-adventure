package io.himoura.interview.leetcode.challenge.may;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 * <b>Cousins in Binary Tree</b>
 * <p>
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1. </br>
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents. </br>
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree. </br>
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * </p>
 * 
 * <dl>
 * <dt>Example 1:</dt>
 * <dd>Input: root = [1,2,3,4], x = 4, y = 3 </br>
 * Output: false</dd>
 * <dt>Example 2:</dt>
 * <dd>Input: root = [1,2,3,null,4,null,5], x = 5, y = 4 </br>
 * Output: true</dd>
 * <dt>Example 3:</dt>
 * <dd>Input: root = [1,2,3,null,4], x = 2, y = 3 </br>
 * Output: false</dd>
 * </dl>
 * 
 * <p>
 * <b>Notes :</b>
 * <ul>
 * <li>The number of nodes in the tree will be between 2 and 100.</li>
 * <li>Each node has a unique integer value from 1 to 100.</li>
 * </ul>
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/">Cousins
 *      in Binary Tree</a>
 * @version 7 mai 2020
 */
public class Day7 {
	public boolean isCousins(TreeNode root, int x, int y) {
		// 1. Find parent of node
		Deque<TreeNode> pathX = getPathFromRoot(Optional.ofNullable(root), x);
		Deque<TreeNode> pathY = getPathFromRoot(Optional.ofNullable(root), y);

		// 2. Compare
		pathX.removeLast();
		pathY.removeLast();
		return pathX.size() == pathY.size() && pathX.getLast().val != pathY.getLast().val;
	}

	Deque<TreeNode> getPathFromRoot(Optional<TreeNode> root, int value) {
		return getPathFromRoot(root, value, new LinkedList<TreeNode>());
	}

	Deque<TreeNode> getPathFromRoot(Optional<TreeNode> root, int value, Deque<TreeNode> path) {
		if (root.isPresent()) {
			final TreeNode node = root.get();
			System.out.format("%d%n", node.val);
			if (node.val == value) {
				path.push(node);
				return path;
			}
			Deque<TreeNode> nodeRecursiveLeft = getPathFromRoot(Optional.ofNullable(node.left), value, path);
			if (!nodeRecursiveLeft.isEmpty()) {
				path.push(node);
				return path;
			}

			Deque<TreeNode> nodeRecursiveRight = getPathFromRoot(Optional.ofNullable(node.right), value, path);
			if (!nodeRecursiveRight.isEmpty()) {
				path.push(node);
				return path;
			}

			return path;
		} else {
			return path;
		}
	}

}
