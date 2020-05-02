package io.himoura.interview.leetcode.challenge.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b>Jewels and Stones</b>
 * 
 * <p>
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * </p>
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * </p>
 * <p>
 * Example 1: <br>
 * Input: J = "aA", S = "aAAbbbb" Output: 3
 * </p>
 * <p>
 * Example 2: <br>
 * Input: J = "z", S = "ZZ" Output: 0
 * </p>
 * Note: <b> S and J will consist of letters and have length at most 50. The
 * characters in J are distinct. </b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/">Jewels
 *      and Stones</a>
 * @version 2 mai 2020
 */
public class Day2 {
	/**
	 * Given m number of element J</br>
	 * Given n number of element S
	 * <ul>
	 * <li>Time Complexity O(m * log m) + O(n * log m) = O((n+m) * log (m))</li>
	 * </ul>
	 * 
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
		// Sort jewels
		final char[] jewels = J.toCharArray();
		Arrays.sort(jewels);
		int result = 0;
		for (int j = 0; j < S.length(); j++) {
			if (Arrays.binarySearch(jewels, S.charAt(j)) > -1) {
				result++;
			}
		}

		return result;
	}

	/**
	 * 
	 * Given m number of element J</br>
	 * Given n number of element S
	 * <ul>
	 * <li>Time Complexity O(m) + O(n) = O(n+m)</li>
	 * <li>Space Complexity O(m)</li>
	 * </ul>
	 * 
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStonesExtraMemory(String J, String S) {
		// Put jewels into Set
		Set<Character> jewels = new HashSet<>();
		for (int i = 0; i < J.length(); i++) {
			jewels.add(J.charAt(i));
		}

		int result = 0;
		for (int j = 0; j < S.length(); j++) {
			if (jewels.contains(S.charAt(j))) {
				result++;
			}
		}

		return result;
	}
}
