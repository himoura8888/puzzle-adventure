package io.himoura.interview.leetcode.easy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BestTimetoBuyandSellStock1Test {

	@DisplayName("Leet Code Test")
	@Test
	void shouldRightValue() {
		// Given
		BestTimetoBuyandSellStock1 buyandSellStock1 = new BestTimetoBuyandSellStock1();

		// When
		int resultProfit = buyandSellStock1.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
		int resultNoProfit = buyandSellStock1.maxProfit(new int[] { 7, 6, 4, 3, 1 });
		int resultNoPrice = buyandSellStock1.maxProfit(new int[] {});
		int resultOneSolution = buyandSellStock1.maxProfit(new int[] { 1, 3 });
		// Then

		assertThat(resultProfit, is(5));
		assertThat(resultNoProfit, is(0));
		assertThat(resultNoPrice, is(0));
		assertThat(resultOneSolution, is(2));
	}

}
