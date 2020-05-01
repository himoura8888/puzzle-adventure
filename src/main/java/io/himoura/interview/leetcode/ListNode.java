package io.himoura.interview.leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		final StringBuilder buffer = new StringBuilder();
		ListNode current = this;
		while (current != null) {
			buffer.append(current.val);
			current = current.next;
		}
		return buffer.toString();
	}
}