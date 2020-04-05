package com.booknara.problem.array;

/**
 * 122. Best Time to Buy and Sell Stock II (Easy)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                total += profit;
            }
        }

        return total;
    }
}
