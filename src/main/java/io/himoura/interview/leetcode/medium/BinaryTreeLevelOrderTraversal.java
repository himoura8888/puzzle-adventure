package io.himoura.interview.leetcode.medium;

import java.util.List;

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

	private final BinaryTreeLevelOrderTraversalAlgorithm algo;

	/**
	 * @param algo
	 */
	public BinaryTreeLevelOrderTraversal(BinaryTreeLevelOrderTraversalAlgorithm algo) {
		this.algo = algo;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		return algo.levelOrder(root);
	}

}
