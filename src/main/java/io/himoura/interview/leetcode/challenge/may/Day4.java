package io.himoura.interview.leetcode.challenge.may;

/**
 * <b>Number Complement</b>
 * <p>
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * 
 * 
 * </br>
 * <dl>
 * Example 1:
 * </dl>
 * <dd></br>
 * Input: 5 </br>
 * Output: 2 </br>
 * <i>Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.</i></dd>
 * 
 * 
 * </br>
 * <dl>
 * Example 2:
 * </dl>
 * <dd></br>
 * Input: 1 </br>
 * Output: 0 </br>
 * <i>Explanation: The binary representation of 1 is 1 (no leading zero bits),
 * and its complement is 0. So you need to output 0.</i></dd>
 * </p>
 * 
 * <p>
 * <i> Note:
 * 
 * </br>
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer. </br>
 * You could assume no leading zero bit in the integer’s binary representation.
 * </br>
 * This question is the same as 1009:
 * https://leetcode.com/problems/complement-of-base-10-integer/ </i>
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/">Number
 *      Complement </a>
 * @version 4 mai 2020
 */
public class Day4 {
	public int findComplement(int num) {

		// Transform binary representation
		char[] numBinary = Integer.toBinaryString(num).toCharArray();

		// Find number complement
		StringBuilder numberComplement = new StringBuilder();
		for (char bit : numBinary) {
			if (bit == '0') {
				numberComplement.append('1');
			} else {
				numberComplement.append('0');
			}
		}
		return Integer.parseInt(numberComplement.toString(), 2);
	}

	public int findComplementOptimized(int num) {
		int cp = num;
		int sum = 0;
		while (num > 0) {
			sum = (sum << 1) + 1;
			num >>= 1;
		}
		return sum - cp;

	}
}
