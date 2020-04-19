package io.himoura.interview.leetcode.challenge.april;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 
 * Write an algorithm to determine if a number n is "happy". A happy number is a
 * number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the
 * process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which this process
 * ends in 1 are happy numbers. Return True if n is a happy number, and False if
 * not.
 * 
 * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 */
public class HappyNumber {

	private static final Logger logger = Logger.getLogger(HappyNumber.class.getName());

	public boolean isHappy(int n) {
		int temp = n;
		do {
			temp = getDigitalFromNumber(temp).stream().map(d -> d * d).reduce(0, (d1, d2) -> d1 + d2);
		} while (temp >= 10);
		return temp == 1 || temp == 7;
	}

	List<Integer> getDigitalFromNumber(int n) {
		int cpt = 0;
		double divisor;
		LinkedList<Integer> result = new LinkedList<>();
		if (n == 0)
			result.push(0);
		else {
			while ((divisor = n / Math.pow(10, cpt)) >= 10) {
				result.push((int) divisor % 10);
				cpt++;
			}
			result.push((int) divisor);
		}
		logger.info(result.toString());
		return result;
	}
}
