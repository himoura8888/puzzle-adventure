package io.himoura.interview.leetcode;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * @see https://leetcode.com/problems/two-sum/
 *
 */
public class TwoNumber {

	/**
	 * @param nums
	 * @param target
	 * @return indices of two number whose summing is equal to target
	 * 
	 *         Time complexity O(n^2)
	 */
	public int[] twoSum(int[] nums, int target) {
		int resultat[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		return resultat;
	}
}
