package io.himoura.interview.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <b>Find All Anagrams in a String</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/">Find
 *      All Anagrams in a String</a>
 * @version 17 mai 2020
 */
public class Day17 {
	public List<Integer> findAnagramsTooLong(String s, String p) {
		List<Integer> result = new ArrayList<>();
		// Edge case
		if (p.length() > s.length()) {
			return result;
		}

		String psorted = p.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());

		// Find all substring have p length
		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			String subStringToCheck = s.substring(i, i + p.length());

			String subStringToCheckSorted = subStringToCheck.chars().sorted().mapToObj(is -> String.valueOf((char) is))
					.collect(Collectors.joining());
			if (Objects.equals(psorted, subStringToCheckSorted)) {
				result.add(i);
			}
		}

		return result;
	}

	/**
	 * Time Complexity O((s-p) * 2p) Space Complexity O(1)
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagramsCopyArray(String s, String p) {

		final int[] pCountLetter = new int[30];
		final char[] sToCharArray = s.toCharArray();
		final List<Integer> result = new ArrayList<>();

		// Edge case
		if (p.length() > s.length()) {
			return result;
		}

		for (int k = 0; k < p.length(); k++) {
			pCountLetter[p.charAt(k) - 'a']++;
		}

		// Find all substring have p length
		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			int[] pCountLetterCopy = Arrays.copyOf(pCountLetter, pCountLetter.length);
			boolean isAnagram = true;
			// Check for each letter from s exists in p
			for (int j = i; j < i + p.length(); j++) {
				if (pCountLetterCopy[sToCharArray[j] - 'a'] == 0) {
					isAnagram = false;
					break;
				}
				pCountLetterCopy[sToCharArray[j] - 'a']--;
			}

			if (isAnagram) {
				result.add(i);
			}
		}
		return result;
	}

	public List<Integer> findAnagrams(String s, String p) {
		int ns = s.length();
		int np = p.length();
		int[] sRef = new int[26];
		int[] pRef = new int[26];
		List<Integer> results = new ArrayList<>();

		if (ns < np) {
			return results; // No solution
		}

		// Build the reference array for p
		for (char ch : p.toCharArray()) {
			pRef[ch - 'a']++;
		}

		// Slide window and compare
		for (int i = 0; i < ns; i++) {
			sRef[s.charAt(i) - 'a']++; // Add right

			if (i >= np) {
				sRef[s.charAt(i - np) - 'a']--; // Remove from left
			}

			if (Arrays.equals(sRef, pRef)) {
				results.add((i - np) + 1);
			}
		}

		return results;
	}

}
