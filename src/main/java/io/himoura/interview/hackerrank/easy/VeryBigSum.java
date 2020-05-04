package io.himoura.interview.hackerrank.easy;

import java.util.stream.LongStream;

public class VeryBigSum {
	// Complete the aVeryBigSum function below.
	static long aVeryBigSum(long[] ar) {
		return LongStream.of(ar).sum();
	}
}
