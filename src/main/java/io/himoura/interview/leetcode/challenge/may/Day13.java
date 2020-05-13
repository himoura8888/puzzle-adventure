package io.himoura.interview.leetcode.challenge.may;

/**
 * <b>Remove K Digits</b>
 * 
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/">Remove
 *      K Digits</a>
 * @version 13 mai 2020
 */
public class Day13 {

	/**
	 * Time Complexity O(k * n) given n length of num
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	public String removeKdigits(String num, int k) {
		int leadingNumberIndex = 0;
		StringBuilder builder = new StringBuilder();
		if (num.length() == k) {
			return "0";
		} else {
			// Assumption : at least one element of result belong to k first + 1 number
			char mininum = 'A';
			int mininumIndex = -1;
			int elementDeleted = 0;
			int left = 0;
			int right = k;
			while (k > 0 && right < num.length()) {
				for (int i = left; i <= right; i++) {
					if (num.charAt(i) < mininum) {
						mininum = num.charAt(i);
						mininumIndex = i;
					}
				}
				// all element to left of mininum are higher
				elementDeleted = mininumIndex - left;
				left = mininumIndex + 1;
				k = k - elementDeleted;
				right = left + k;
				builder.append(mininum);
				mininum = 'A';
			}

			// K digits are already removed, so put number left into result
			for (int i = right; i < num.length(); i++) {
				builder.append(num.charAt(i));
			}

			// Remove leading zero
			for (int i = 0; i < builder.length(); i++) {
				if (builder.charAt(i) == '0') {
					leadingNumberIndex++;
				} else {
					break;
				}
			}
			// Only Zero
			if (leadingNumberIndex == builder.length()) {
				return "0";
			}

		}

		return builder.substring(leadingNumberIndex);
	}

}
