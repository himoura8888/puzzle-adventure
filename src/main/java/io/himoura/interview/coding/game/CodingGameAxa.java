package io.himoura.interview.coding.game;

public class CodingGameAxa {
	
	int sum(int ints[]) {
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			int n = ints[i];
			if (n>=10 && n<=20) {
				sum += n;
			}
		}
		return sum;
	}

}
