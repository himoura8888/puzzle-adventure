package io.himoura.kata.tree;

import java.util.Random;
import java.util.function.Supplier;

public class BinaryTreeGame {

	public static TreeNodeGame buildRecursiveEvalutionFunction(int depth) {
		return BinaryTreeGame.help(depth, () -> new Random().nextInt(256), true, "");
	}

	static TreeNodeGame help(int depth, Supplier<Integer> supplier, boolean isMaximizer, String strike) {
		if (depth == 1) {
	
			Long countL = strike.chars().mapToObj(i -> (char) i).filter(c -> c == 'R').count();
			Long countR = strike.chars().mapToObj(i -> (char) i).filter(c -> c == 'L').count();
	
			return new TreeNodeGame((int) (countL - countR));
		}
		final TreeNodeGame treeNode = new TreeNodeGame();
		treeNode.left = help(depth - 1, supplier, !isMaximizer, strike + "L");
		treeNode.left.strike = treeNode.strike + "L";
		treeNode.right = help(depth - 1, supplier, !isMaximizer, strike + "R");
		treeNode.right.strike = treeNode.strike + "R";
		if (isMaximizer) {
			treeNode.val = Math.max(treeNode.left.val, treeNode.right.val);
		} else {
			treeNode.val = Math.min(treeNode.left.val, treeNode.right.val);
		}
		return treeNode;
	}

}
