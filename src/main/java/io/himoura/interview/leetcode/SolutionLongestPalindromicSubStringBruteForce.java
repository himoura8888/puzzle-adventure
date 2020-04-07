package io.himoura.interview.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author LeetCode
 * @see <a href=
 *      "https://leetcode.com/problems/longest-palindromic-substring/">source</a>
 */
public class SolutionLongestPalindromicSubStringBruteForce implements SolutionLongestPalindromicSubString {

	@Override
	public String longestPalindromic(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return "";
		else {
			return getAllSubString(s).stream().filter(this::isPalindrome)
					.max((s1, s2) -> s1.length() - s2.length() > 0 ? 0 : -1).orElse("");
		}
	}

	List<String> getAllSubString(String source) {

		final List<String> result = new LinkedList<>();

		for (int start = 0; start < source.length(); start++) {
			for (int end = start; end++ < source.length();)
				result.add(source.substring(start, end));
		}

		return result;
	}

	boolean isPalindrome(String source) {
		boolean result = true;

		char[] sourceChar = source.toCharArray();
		final int middle = sourceChar.length / 2;
		for (int index = 0; index <= middle; index++) {
			result &= sourceChar[index] == sourceChar[sourceChar.length - 1 - index];
		}

		return result;

	}
}
