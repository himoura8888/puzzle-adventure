package io.himoura.interview.leetcode.challenge.april;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

	@DisplayName("LeetCode Test")
	@Test
	void shouldLeetCodeExpectedResult() {

		// Given
		GroupAnagrams groupAnagrams = new GroupAnagrams();
		// When
		List<List<String>> result = groupAnagrams
				.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		// Then
		assertThat(result.get(0), containsInAnyOrder("ate", "eat", "tea"));
		assertThat(result.get(1), containsInAnyOrder("nat", "tan"));
		assertThat(result.get(2), containsInAnyOrder("bat"));
	}

}
