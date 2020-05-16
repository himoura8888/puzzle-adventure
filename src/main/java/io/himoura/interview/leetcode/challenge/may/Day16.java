package io.himoura.interview.leetcode.challenge.may;

import io.himoura.interview.leetcode.ListNode;

/**
 * <b>Odd Even Linked List</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/">Odd
 *      Even Linked List</a>
 * @version 16 mai 2020
 */
public class Day16 {
	/**
	 * Time Complexity O(n) Space Complexity O(1)
	 * 
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {

		if (head == null) {
			return null;
		}

		// ListNode contains 1 or 2 nodes is already ordered
		if (head.next == null || head.next.next == null) {
			return head;
		}
		// Use 2 pointers :
		// One references odd node
		// Other references even node
		// At the end, one links other
		ListNode odd, even, startEvent;
		odd = head;
		startEvent = odd.next;
		even = startEvent;
		while (odd.next != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			odd = odd.next;
			even = even.next;
		}
		odd.next = startEvent;
		return head;
	}
}
