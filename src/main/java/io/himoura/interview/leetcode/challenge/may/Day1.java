package io.himoura.interview.leetcode.challenge.may;

/**
 * <h1>First Bad Version</h1>
 * <p>
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * </p>
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * </p>
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * </p>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/">First
 *      Bad Version</a>
 * @version 1 mai 2020
 */
public class Day1 {
//	private static final int HALF_MAX = Integer.MAX_VALUE / 2;
	private final int badVersion;

	/**
	 * @param version number doesn't works anymore
	 */
	public Day1(int version) {
		badVersion = version;
	}

	public int firstBadVersionBruteForce(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (isBadVersion(i)) {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * Divide and conquer
	 * 
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {
		int start, end, middle;
		start = 1;
		end = n;
		middle = 0;

		while (start != end) {
			if (isBadVersion(middle = start + (end - start) / 2)) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}

		return start;
	}

	private boolean isBadVersion(int i) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.print("Time out");
			System.exit(0);
		}
		if (i >= badVersion)
			return true;
		else
			return false;
	}

}
