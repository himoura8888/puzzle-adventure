package io.himoura.interview.test;

class Palindrome {
	
	static boolean isPalindrom(String word) {
		
		char[] characters = word.toCharArray();
		boolean result = true;
		final int middle = characters.length/2+1;
		for (int i = 0; i < middle && result; i++) {
			result = characters[i] == characters[characters.length-1-i];
		}
		return result;		
		
	}
}
