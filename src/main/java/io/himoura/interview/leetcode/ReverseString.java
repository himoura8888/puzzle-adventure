package io.himoura.interview.leetcode;

public class ReverseString {

	public void reverseString(char[] s) {
		reverseString(s, 0);
	}

	private void reverseString(char[] str, int index) {

		if (str == null || index >= str.length / 2) {
			return;
		}

		reverseString(str, index + 1);
		char swap = str[str.length - 1 - index];
		str[str.length - 1 - index] = str[index];
		str[index] = swap;
	}

}
