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
	 * Verify num is square of number
	 * 
	 * @param num possible square of number
	 * @return true if num is square otherwise false
	 */
	public boolean isPerfectSquare(int num) {

		int incr = 0;
		while (incr * incr < num) {
			incr++;
		}
		return incr * incr == num;
	}
}
