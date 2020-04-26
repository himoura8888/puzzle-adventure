package io.himoura.interview.leetcode.easy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountAndSayTest {

	@DisplayName("LeetCode test")
	@Test
	void shouldLeetCodeResult() {

		// Given
		CountAndSay countAndSay = new CountAndSay();

		// When
		String resultRank1 = countAndSay.countAndSay(1);
		String resultRank4 = countAndSay.countAndSay(4);
		String resultRank5 = countAndSay.countAndSay(5);
		String resultRank6 = countAndSay.countAndSay(6);
		String resultRank7 = countAndSay.countAndSay(7);

		// Then
		assertThat(resultRank1, is("1"));
		assertThat(resultRank4, is("1211"));
		assertThat(resultRank5, is("111221"));
		assertThat(resultRank6, is("312211"));
		assertThat(resultRank7, is("13112221"));
	}

}
