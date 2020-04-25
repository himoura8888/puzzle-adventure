/**
 * 
 */
package io.himoura.interview.leetcode.challenge.april;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * @version 24 avr. 2020
 * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
 */
public class MoveZeroes {

	/**
	 * @param nums
	 * @return nums whose all zero are at the end
	 */
	public int[] moveZeroes(int[] nums) {

		int noZeroIndex = 0;
		// Add only no zero value at the begin of array
		for (int i = 0; i < nums.length; i++) {
			final int value = nums[i];
			if (value != 0) {
				nums[noZeroIndex++] = value;
			}
		}

		// Pad with zero
		for (int j = noZeroIndex++; j < nums.length; j++) {
			nums[j] = 0;
		}

		return nums;
	}
}
