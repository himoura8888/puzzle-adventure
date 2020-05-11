package io.himoura.kata.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;

import io.himoura.interview.leetcode.challenge.may.TreeNode;

public class BinaryTree {
	static int cpt;

	/**
	 * Find parent of specific node.This node equals to val.
	 * 
	 * @param root
	 * @param val
	 * @return parent
	 */
	static void displayTreeNode(TreeNode root) {
		if (root != null) {
			System.out.format("%d%n", root.val);
			displayTreeNode(root.left);
			displayTreeNode(root.right);
		}
	}

	static void displayTreeNodeInfix(TreeNode root) {
		if (root != null) {
			displayTreeNodeInfix(root.left);
			System.out.format("%d%n", root.val);
			displayTreeNodeInfix(root.right);
		}
	}

	static void displayTreeNodeLevel(TreeNode root, int depth) {

		Queue<TreeNode> nodes = new LinkedList<>();
		int countLevel = 1;
		int countChildren = 0;
		boolean isPadding = true;
		nodes.add(root);
		double numberPadding = 0;
		double space = 0;
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			countLevel--;
			if (isPadding) {
				numberPadding = Math.pow(2, --depth) - 1;
				for (int i = 0; i++ < numberPadding;) {
					System.out.print(" ");
				}
				isPadding = false;
			}
			System.out.print(node.val);
			for (int i = 0; i++ < space;) {
				System.out.print(" ");
			}
			if (node.left != null) {
				countChildren++;
				nodes.offer(node.left);
			}
			if (node.right != null) {
				countChildren++;
				nodes.offer(node.right);
			}

			if (countLevel == 0) {
				System.out.println(" ");
				countLevel = countChildren;
				space = numberPadding;
				countChildren = 0;
				isPadding = true;
			}
		}
	}

	static int countTreeNode(TreeNode root) {
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
//			System.out.format("%d%n", node.val);
			if (node.val == value) {
				return node;
			} else {
				fifo.push(node.right);
				fifo.push(node.left);
			}
		}
		return new TreeNode();
	}

	boolean containsValueRecursiveFull(TreeNode root, int value) {
		if (root != null) {
			cpt++;
			return root.val == value | containsValueRecursiveFull(root.left, value)
					| containsValueRecursiveFull(root.right, value);
		} else {
			return false;
		}
	}

	boolean containsValueRecursive(TreeNode root, int value) {
		if (root != null) {
			cpt++;
//			System.out.println(root.val);
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
//			System.out.format("%d%n", node.val);
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

	static int getDepth(TreeNode root) {
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

	public static TreeNode buildLarge(int number) {
		return build(number, false);
	}

	public static TreeNode buildTall(int number) {
		return build(number, true);
	}

	private static TreeNode build(int number, boolean isVeryHeight) {
		if (number % 2 == 0 && !isVeryHeight) {
			throw new IllegalArgumentException("number must be odd");
		}
		final Deque<TreeNode> nodeToAddChildren = new LinkedList<>();
		final TreeNode root = new TreeNode();
		nodeToAddChildren.offer(root);
		final Random random = new Random();

		if (isVeryHeight) {
			for (int i = 1; i < number; i++) {
				TreeNode result = nodeToAddChildren.poll();

				if (random.nextBoolean()) {
					result.left = new TreeNode(random.nextInt(500));
					nodeToAddChildren.offer(result.left);
				} else {
					result.right = new TreeNode(random.nextInt(500));
					nodeToAddChildren.offer(result.right);
				}
			}
		} else {
			for (int i = 0; i < number / 2; i++) {
				TreeNode result = nodeToAddChildren.poll();
				result.left = new TreeNode(random.nextInt(500));
				result.right = new TreeNode(random.nextInt(500));
				nodeToAddChildren.offer(result.left);
				nodeToAddChildren.offer(result.right);
			}
		}

		return root;
	}

	public static TreeNode buildRecursive(int depth) {

		if (depth == 0) {
			return null;
		}
		final TreeNode treeNode = new TreeNode(depth);
		treeNode.left = buildRecursive(depth - 1);
		treeNode.right = buildRecursive(depth - 1);
		return treeNode;
	}

	static int maxValue(TreeNode node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		} else {
			return Integer.max(node.val, Integer.max(maxValue(node.left), maxValue(node.right)));

		}
	}

	Optional<TreeNode> nodeHighestValue(TreeNode node) {
		if (node == null) {
			return Optional.of(new TreeNode());
		} else {
			TreeNode result;
			final Optional<TreeNode> maxValueLeft = nodeHighestValue(node.left);
			final Optional<TreeNode> maxValueRight = nodeHighestValue(node.right);

			if (maxValueLeft.get().val > maxValueRight.orElse(new TreeNode()).val
					&& maxValueLeft.get().val > node.val) {
				result = maxValueLeft.get();
			} else if (maxValueRight.get().val > maxValueLeft.orElse(new TreeNode()).val
					&& maxValueRight.get().val > node.val) {
				result = maxValueRight.get();
			} else {
				result = node;
			}
			return Optional.ofNullable(result);
		}

	}

	int countValue(TreeNode node, int value) {
		if (node == null) {
			return 0;
		} else {
			return node.val == value ? 1 : 0 + countValue(node.left, value) + countValue(node.right, value);
		}
	}
}
