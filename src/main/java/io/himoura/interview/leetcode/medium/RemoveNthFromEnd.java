package io.himoura.interview.leetcode.medium;

import io.himoura.interview.leetcode.ListNode;

/**
 * <b>19. Remove Nth Node From End of List</b>
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * </p>
 * <p>
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * </p>
 * 
 * Note:
 * 
 * <b>Given n will always be valid.</b>
 * 
 * <p>
 * Follow up:
 * 
 * Could you do this in one pass?
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/problems/remove-nth-node-from-end-of-list/"></a>
 * @version 2 mai 2020
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode defaultNode = new ListNode();
		defaultNode.next = head;
		ListNode current = defaultNode;
		ListNode previousRemoveNode = defaultNode;
		int cpt = 1;
		while (current.next != null) {
			if (cpt++ >= n + 1) {
				previousRemoveNode = previousRemoveNode.next;
			}
			current = current.next;
		}
		previousRemoveNode.next = previousRemoveNode.next.next;

		return defaultNode.next;
	}
}
