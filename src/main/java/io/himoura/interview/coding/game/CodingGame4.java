package io.himoura.interview.coding.game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 
 * You are a given a sequence of characters consisting of parentheses () and brackets[].
 * A string of this type is said to be correct :
 * 
 * if it is an empty or null string
 * if the string A is correct, (A) and [A] are correct
 * if th string A and B are correct, the concatenation AB is also correct
 * Input : The string contains at most 10 000 characters.
 * 
 * Examples : [()] is correct, (()[]) is correct, ([)]) is not correct, (( is not correct
 * 
 * Implement the method check(String str) to check the correctness of a string of this type. check returns true if the string is correct, false otherwise
 */
public class CodingGame4 {
	
	static boolean check(String str) {
		
		Deque<String> stack = new LinkedList<>();
		for(String character : str.split("")) {
			if ("[".equals(character) || "(".contentEquals(character)) {
				stack.push(character);
			}
			if ("]".equals(character) ) {
				if (Objects.equals(stack.peek(),"["))
					stack.poll();
				else 
					return false;
			}
			if (")".equals(character)) {
				if (Objects.equals(stack.peek(),"("))
					stack.poll();
				else
					return false;
			}
		}
		
		return stack.isEmpty();
	}

}
