package io.himoura.interview.leetcode.challenge.may;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.himoura.interview.leetcode.ListNode;

class Day16Test {

	@DisplayName("LeetCode example")
	@Test
	void shouldReturnLeetCodeResult() {

		// Given
		final Day16 day16 = new Day16();
		final ListNode example1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		final ListNode example2 = new ListNode(2,
				new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
		// When
		final ListNode result1 = day16.oddEvenList(example1);
		final ListNode result2 = day16.oddEvenList(example2);

		// Then
		assertThat(result1.toString(), is("13524"));
		assertThat(result2.toString(), is("2367154"));
	}

	@DisplayName("Edge case")
	@Test
	void shouldReturnInputValue() {

		// Given
		final Day16 day16 = new Day16();
		final ListNode oneNode = new ListNode(1);
		final ListNode twoNode = new ListNode(1, new ListNode(2));
		// When
		final ListNode result1 = day16.oddEvenList(oneNode);
		final ListNode result2 = day16.oddEvenList(twoNode);

		// Then
		assertThat(result1.toString(), is("1"));
		assertThat(result2.toString(), is("12"));
	}

	@DisplayName("total of node is even number")
	@Test
	void shouldReturnDDd() {

		// Given
		final Day16 day16 = new Day16();
		// When
		final ListNode totalNodeIsEvenNumber = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		final ListNode target = day16.oddEvenList(totalNodeIsEvenNumber);

		// Then
		assertThat(target.toString(), is("1324"));
	}

}
