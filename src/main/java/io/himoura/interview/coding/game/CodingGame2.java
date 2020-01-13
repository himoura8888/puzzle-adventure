package io.himoura.interview.coding.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CodingGame2 {
	
	/**
	 * Transform character into graphical
	 * @param c character from A to Z
	 * @return graphical representation
	 */
	static String printChar(char c) {
		return String.join("-",String.valueOf(c),String.valueOf(c));
	}
	
	/**
	 * Get character related to 
	 * @param s graphical representation
	 * @return character associated graphical representation
	 */
	static char scanChar(String s) {
		
		
		Map<String, Character> dictionnary = new HashMap<>();
		
		for(char i='A';i<='Z';i++) {
			dictionnary.put(printChar(i), i);
		}
		
		return Objects.isNull(dictionnary.get(s)) ? '?' : dictionnary.get(s);
	}
	
	

}
