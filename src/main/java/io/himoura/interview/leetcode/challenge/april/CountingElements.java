package io.himoura.interview.leetcode.challenge.april;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
 * @version 27 avr. 2020
 */
public class CountingElements {
	public int countElements(int[] arr) {
		int result = 0;
		Set<Integer> numberPresent = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			numberPresent.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (numberPresent.contains(arr[i] + 1)) {
				result++;
			}
		}
		return result;
	}
}
