package io.himoura.interview.leetcode.medium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.himoura.interview.leetcode.ListNode;

class RemoveNthFromEndTest {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturn() {
		// Given
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		// When
		ListNode result = removeNthFromEnd.removeNthFromEnd(head, 2);

		assertThat(result.toString(), is("1235"));
	}

	@DisplayName("Limit value")
	@Test
	void shouldRemoveElement() {

		// Given
		final RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		final ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		final ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		final ListNode head3 = new ListNode(1, new ListNode(2));
		final ListNode head4 = new ListNode(1);
		final ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3)));

		// When
		ListNode resultRemoveFirst = removeNthFromEnd.removeNthFromEnd(head1, 5);
		ListNode resultRemoveLast = removeNthFromEnd.removeNthFromEnd(head2, 1);
		ListNode result2NodeFirst = removeNthFromEnd.removeNthFromEnd(head3, 2);
		ListNode result2NodeLast = removeNthFromEnd.removeNthFromEnd(head3, 1);
		ListNode result1NodeLast = removeNthFromEnd.removeNthFromEnd(head4, 1);
		ListNode result1NodeMiddle = removeNthFromEnd.removeNthFromEnd(head5, 2);

		// Then
		assertThat(resultRemoveFirst.toString(), is("2345"));
		assertThat(resultRemoveLast.toString(), is("1234"));
		assertThat(result2NodeFirst.toString(), is("2"));
		assertThat(result2NodeLast.toString(), is("1"));
		assertThat(result1NodeLast, nullValue());
		assertThat(result1NodeMiddle.toString(), is("13"));

	}

}
