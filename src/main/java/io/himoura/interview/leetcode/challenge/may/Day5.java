package io.himoura.interview.leetcode.challenge.may;

import java.util.Objects;

/**
 * <b>First Unique Character in a String</b>
 * 
 * <p>
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * <dl>
 * Examples:
 * </dl>
 * <dd></br>
 * s = "leetcode" return 0. </br>
 * s = "loveleetcode", return 2.</dd> </br>
 * <b> Note: You may assume the string contain only lowercase letters. </b>
 * </p>
 * 
 * @version 5 mai 2020
 */
public class Day5 {

	/**
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		int result = -1;
		if (Objects.isNull(s) || s.length() == 0) {
			return result;
		}

		// Store state unique of every character
		final char[] characters = s.toCharArray();
		final int[] states = new int[256];
		for (int i = 0, len = characters.length; i < len; i++) {
			states[characters[i]]++;
		}

		// Find index of the first character non-repeating
		for (int i = 0, len = characters.length; i < len; i++) {
			if (states[characters[i]] == 1) {
				return i;
			}
		}

		return result;
	}

}
