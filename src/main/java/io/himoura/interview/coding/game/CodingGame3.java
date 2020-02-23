package io.himoura.interview.coding.game;

import java.util.LinkedList;

public class CodingGame3 {

}

class Node{
	
	Node left, right;
	int value;
	
	public Node() {}
	
	/**
	 * @param left
	 * @param right
	 * @param value
	 */
	public Node(Node left, Node right, int value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public Node find(int i) {
		if (this.value == i)
			return this;
		else {
			if (this.value > i){
				return this.left.find(i);
			}
			else {
				return this.right.find(i);
			}
		}
	}
	
	public Node findIterativeWay(int i) {
		// stock nodes have to be visited
		LinkedList<Node> nodesToVisit = new LinkedList<>();
		
		nodesToVisit.add(this);
		
		while(!nodesToVisit.isEmpty()) {
			Node currentNode = nodesToVisit.poll();
			if (currentNode.value == i)
				return currentNode;
			else {
				if (this.value > i){
					nodesToVisit.add(currentNode.left);
				}
				else {
					nodesToVisit.add(currentNode.right);
				}
			}
		}
		return null;
	}
	
}
