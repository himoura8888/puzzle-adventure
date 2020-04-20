package io.himoura.interview.leetcode.challenge.april;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * @version 20 avr. 2020
 */
public class MaximumArray {

	public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		// Get all subarray
		for (int start = 0; start < nums.length; start++) {
			int sumSubArray = 0;
			for (int end = start; end < nums.length; end++) {
				sumSubArray += nums[end];
				result = result < sumSubArray ? sumSubArray : result;
			}
		}

		return result;
	}

}
