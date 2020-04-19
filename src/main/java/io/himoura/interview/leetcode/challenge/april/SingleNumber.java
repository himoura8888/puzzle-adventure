package io.himoura.interview.leetcode.challenge.april;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
 */
public class SingleNumber {

	/**
	 * @param nums non-empty array of integers
	 * @return element that appears only once.
	 */
	public int singleNumber(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0)
			throw new IllegalArgumentException("parameter must be non-empty array of integers");
		else {
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				if (map.containsKey(num))
					map.remove(num);
				else
					map.put(num, num);
			}
			return map.keySet().iterator().next();
		}
	}

}
