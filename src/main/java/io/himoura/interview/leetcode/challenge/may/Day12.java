package io.himoura.interview.leetcode.challenge.may;

/**
 * <b>Single Element in a Sorted Array</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/">Single
 *      Element in a Sorted Array</a>
 * @see <a href=
 *      "https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/">Solution
 *      GeekForGeek</a>
 * @version 12 mai 2020
 */
public class Day12 {

	/**
	 * number has even index then its duplicate has odd index ex. [1,1,2] For number
	 * 1, Index 0 Then 1 </br>
	 * Single number changes even odd order ex. [0,1,1] For Number 1, Index 1 Then 2
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNonDuplicate(int[] nums) {
		int left, right, middle;
		left = 0;
		right = nums.length - 1;

		while (left < right) {
			middle = left + (right - left) / 2;
			if (middle % 2 == 0) {
				if (nums[middle] == nums[middle + 1]) {
					left = middle + 2;
				} else {
					right = middle;
				}
			} else {
				if (nums[middle] != nums[middle + 1]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}

		}
		return nums[left];
	}

	public int singleNonDuplicateXor(int[] nums) {

		int previous = 0;
		for (int i = 0; i < nums.length; i++) {
			previous = nums[i] ^ previous;
		}
		return previous;
	}

	public int singleNonDuplicateLoop(int[] nums) {

		int previous = nums[0];
		boolean isDuplicate = true;
		for (int i = 1; i < nums.length; i++) {
			if (previous == nums[i]) {
				isDuplicate = true;
			} else {
				if (isDuplicate) {
					isDuplicate = false;
					previous = nums[i];
				} else {
					return previous;
				}
			}

		}
		return -1;
	}
}
