package io.himoura.interview.leetcode.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @version 26 avr. 2020
 */
public class BestTimetoBuyandSellStock1 {

	/**
	 * Find max profit for all couple of buy and sell time complexity O(n^2)
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfitBruteForce(int[] prices) {
		int profit = 0;
		for (int buy = 0; buy < prices.length - 1; buy++) {
			for (int sell = buy + 1; sell < prices.length; sell++) {
				profit = Math.max(profit, prices[sell] - prices[buy]);
			}
		}
		return profit;
	}

	/**
	 * Buy at lowest price and sell at peek time complexity O(n)
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		int lowestprice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - lowestprice);
			lowestprice = Math.min(lowestprice, prices[i]);
		}
		return profit;
	}

}
