package io.himoura.interview.leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Ransom Note</b>
 * <p>
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * </br>
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * </br>
 * <b>Note: You may assume that both strings contain only lowercase letters.</b>
 * <p>
 * <p>
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/">Ransom
 *      Note</a>
 * @version 3 mai 2020
 */
public class Day3 {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (magazine == null || magazine.length() == 0) {
			return ransomNote == null || ransomNote.length() == 0;
		}
		if (ransomNote == null || ransomNote.length() == 0) {
			return true;
		}

		// Stock every letter of magazine with count
		final Map<Character, Integer> letterWithCount = new HashMap<>();

		for (int i = 0; i < magazine.length(); i++) {
			letterWithCount.merge(magazine.charAt(i), 1, Integer::sum);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			int count = letterWithCount.getOrDefault(ransomNote.charAt(i), 0);
			if (count < 1) {
				return false;
			} else {
				letterWithCount.put(ransomNote.charAt(i), --count);
			}
		}

		return true;
	}
}
