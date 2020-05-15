package io.himoura.interview.leetcode.challenge.may;

import java.util.stream.IntStream;

/**
 * <b>Maximum Sum Circular Subarray</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/">Maximum
 *      Sum Circular Subarray</a>
 * @version 16 mai 2020
 */
public class Day15 {
	public int maxSubarraySumCircular(int[] A) {

		final int kadane = kadane(A);
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i];
		}

		final int maxOutBound = IntStream.of(A).sum() + kadane(A);
		if (maxOutBound == 0)
			return kadane;
		else
			return Math.max(kadane, maxOutBound);
	}

	int kadane(int a[]) {
		int maxSumElement = Integer.MIN_VALUE, sumElement = 0;

		for (int element : a) {
			sumElement = sumElement + element;
			maxSumElement = Math.max(sumElement, maxSumElement);
			if (sumElement < 0)
				sumElement = 0;
		}
		return maxSumElement;
	}
}
