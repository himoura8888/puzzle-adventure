package io.himoura.interview.coding.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Binary Tree Search")
class CodingGame3Test {
	
	@DisplayName("Small Tree")
	@Test
	void small() {
		Node node3 = new Node(null,null,6);
		Node node6 = new Node(null, null, 30);
		Node node7 = new Node(null, null, 15);
		Node node2 = new Node(null,node3,3);
		Node node5 = new Node(null, node7, 12);
		Node node4 = new Node(node5,node6,23);
		Node node1 = new Node(node2,null,7);
		Node root = new Node(node1, node4, 10);
	
		assertThat(root.find(30), sameInstance(node6));
		assertThat(root.find(23), sameInstance(node4));
	}
	
	@Test
	void large() {
		
		Node large = new Node();
		Node t = large;
		for(int i=1;i<1000000;i++) {
			t.value = i;
			t.right = new Node();	
			t = t.right;
		}
		assertThat(large.findIterativeWay(100000).value, is(100000));
		assertThrows(StackOverflowError.class,()-> large.find(100000));
	}

}
