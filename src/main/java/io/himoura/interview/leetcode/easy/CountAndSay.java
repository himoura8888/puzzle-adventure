package io.himoura.interview.leetcode.easy;

import java.util.Objects;

/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * <p>
 * <ol>
 * <li>1</li>
 * <li>11</li>
 * <li>21</li>
 * <li>1211</li>
 * <li>111221</li>
 * </ol>
 * </p>
 * <p>
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * </p>
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence. You can do so recursively, in other words from the
 * previous member read off the digits, counting the number of digits in groups
 * of the same digit.
 * </p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * @see https://leetcode.com/problems/count-and-say/
 * @version 26 avr. 2020
 */
public class CountAndSay {

	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		else {
			return sayCompositionOfNumber(countAndSay(n - 1));
		}
	}

	/**
	 * @param number
	 * @return
	 */
	private String sayCompositionOfNumber(String number) {
		String previous = "";
		StringBuilder result = new StringBuilder();
		int countCharacterPrevious = 0;
		for (String character : number.split("")) {
			if (Objects.equals(previous, character)) {
				countCharacterPrevious++;
			} else {
				result.append(countCharacterPrevious).append(previous);
				previous = character;
				countCharacterPrevious = 1;
			}
		}
		result.append(countCharacterPrevious).append(previous);
		return result.toString().substring(1);
	}

}
