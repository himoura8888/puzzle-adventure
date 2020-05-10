package io.himoura.interview.hackerrank.medium;

import java.util.Objects;

/**
 * 
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/counter-game/problem">Counter
 *      Game</a>
 * @version 10 mai 2020
 */
public class CounterGame {

	static String counterGame(long n) {
		String currentPlayer = "Louise";

		// Stock all value of 2^n n from 0 to 63
		long powvalues[] = new long[63];
		for (int exp = 0; exp < 63; exp++) {
			powvalues[exp] = 1l << exp;
		}

		while (n > 1) {
			final long floor = getCeilExponent(n, powvalues);

			if (floor - n == 0) {
				n = n >> 1;
			} else {
				n = n - floor;
			}

			if (n != 1) {
				currentPlayer = Objects.equals(currentPlayer, "Richard") ? "Louise" : "Richard";
			}
		}

		return currentPlayer;
	}

	static Long getCeilExponent(long n, long[] powvalues) {
		long floor = Integer.MAX_VALUE;
		int left = 0;
		int right = powvalues.length - 1;

		if (n < powvalues[left]) {
			return powvalues[left];
		}
		if (n > powvalues[right]) {
			return powvalues[right];
		}
		for (int i = 0; i < powvalues.length; i++) {
			int middle = left + (right - left) / 2;
			if (powvalues[middle] == n) {
				return n;
			} else if (powvalues[middle] > n) {
				right = middle;
			} else {
				left = middle;
			}
			if (right - left == 1) {
				return powvalues[left];
			}
		}

		return floor;
	}
}
