package io.himoura.interview.coding.game;

import java.util.Objects;

/**
 *  Time limit : 5mn
 *
 */
public class CodingGame1 {
	
	/**
	 * Should return the largest number form <code>numbers</code>. The array <code>numbers</code> always contains at least one number.
	 * @param numbers array of integer
	 * @return largest number
	 */
	static int findLargest(int[] numbers) {
		
		if(Objects.isNull(numbers) || numbers.length < 1) {
			throw new IllegalArgumentException("Contains at least one value");
		}
		
		int largestValue = Integer.MIN_VALUE;
		for(int i=numbers.length;--i>=0;) {
			
			if(largestValue < numbers[i]) {
				largestValue = numbers[i];
			}
		}
		return largestValue;
	}

}
