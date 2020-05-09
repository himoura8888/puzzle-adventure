package io.himoura.interview.leetcode.challenge.may;

/**
 * <b>Valid Perfect Square</b>
 * <p>
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * </p>
 * <p>
 * <dl>
 * <dt>Example 1:</dt>
 * <dd>Input: 16</br>
 * Output: true</dd>
 * <dt>Example 2:</dt>
 * <dd>Input: 14</br>
 * Output: false</dd>
 * </dl>
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/">Valid
 *      Perfect Square</a>
 * @version 9 mai 2020
 */
public class Day9 {
	/**
	 * Verify num is square of number Time Complexity O(log2)
	 * 
	 * @param num possible square of number
	 * @return true if num is square otherwise false
	 */
	public boolean isPerfectSquare(int num) {

		int left = 2;
		int right = num;

		if (num < 1) {
			return false;
		}
		if (num == 1) {
			return true;
		}

		while (left <= right) {
			final int middle = left + (right - left) / 2;
			final long squareMiddle = (long) middle * (long) middle;
			if (squareMiddle == num) {
				return true;
			}
			if (squareMiddle > num) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return false;
	}
}
