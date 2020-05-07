package io.himoura.kata.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

public class BinaryTree {
	/**
	 * Find parent of specific node.This node equals to val.
	 * 
	 * @param root
	 * @param val
	 * @return parent
	 */
	void displayTreeNode(TreeNode root) {
		if (root != null) {
//			System.out.format("%d%n", root.val);
			displayTreeNode(root.left);
			displayTreeNode(root.right);
		}
	}

	int countTreeNode(TreeNode root) {
		if (root != null) {
			return countTreeNode(root.left) + countTreeNode(root.right) + 1;
		} else {
			return 0;
		}
	}

	boolean containsValueIterative(TreeNode root, int value) {
		final Deque<TreeNode> fifo = new LinkedList<>();
		fifo.push(root);
		while (!fifo.isEmpty()) {
			TreeNode node = fifo.poll();
			if (node == null) {
				continue;
			}
			if (node.val == value) {
				return true;
			} else {
				fifo.push(node.right);
				fifo.push(node.left);
			}
		}
		return false;
	}

	TreeNode getNodeIterative(TreeNode root, int value) {
		final Deque<TreeNode> fifo = new LinkedList<>();
		fifo.push(root);
		while (!fifo.isEmpty()) {
			TreeNode node = fifo.poll();
			if (node == null) {
				continue;
			}
			System.out.format("%d%n", node.val);
			if (node.val == value) {
				return node;
			} else {
				fifo.push(node.right);
				fifo.push(node.left);
			}
		}
		return new TreeNode();
	}

	boolean containsValueRecursive(TreeNode root, int value) {
		if (root != null) {
			if (root.val == value) {
				return true;
			}
			if (containsValueRecursive(root.left, value))
				return true;
			else if (containsValueRecursive(root.right, value))
				return true;
			return false;
		} else {
			return false;
		}
	}

	Optional<TreeNode> getNodeRecursive(Optional<TreeNode> root, int value) {

		if (root.isPresent()) {
			final TreeNode node = root.get();
			System.out.format("%d%n", node.val);
			if (node.val == value) {
				return Optional.of(node);
			}
			final Optional<TreeNode> nodeRecursiveRight = getNodeRecursive(Optional.ofNullable(node.right), value);
			final Optional<TreeNode> nodeRecursiveLeft = getNodeRecursive(Optional.ofNullable(node.left), value);
			if (nodeRecursiveRight.isPresent())
				return nodeRecursiveRight;
			if (nodeRecursiveLeft.isPresent())
				return nodeRecursiveLeft;

			return Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	Optional<TreeNode> getParentNodeRecursive(Optional<TreeNode> root, int value) {
		return getParentNodeRecursive(root, value, root);
	}

	private Optional<TreeNode> getParentNodeRecursive(Optional<TreeNode> root, int value, Optional<TreeNode> parent) {

		if (root.isPresent()) {
			final TreeNode node = root.get();
			if (node.val == value) {
				return parent;
			}

			// Look at right first
			final Optional<TreeNode> nodeRecursiveRight = getParentNodeRecursive(Optional.ofNullable(node.right), value,
					root);
			if (nodeRecursiveRight.isPresent())
				return nodeRecursiveRight;

			final Optional<TreeNode> nodeRecursiveLeft = getParentNodeRecursive(Optional.ofNullable(node.left), value,
					root);
			if (nodeRecursiveLeft.isPresent())
				return nodeRecursiveLeft;

			return Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	int getDepth(TreeNode root) {
		if (root != null) {

			final int getDepthLeft = getDepth(root.left);
			final int getDepthRight = getDepth(root.right);

			if (getDepthLeft > getDepthRight)
				return getDepthLeft + 1;
			else
				return getDepthRight + 1;
		} else {
			return 0;
		}
	}

	Deque<TreeNode> getPathFromRoot(Optional<TreeNode> root, int value) {
		return getPathFromRoot(root, value, new LinkedList<TreeNode>());
	}

	Deque<TreeNode> getPathFromRoot(Optional<TreeNode> root, int value, Deque<TreeNode> path) {
		if (root.isPresent()) {
			final TreeNode node = root.get();
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
