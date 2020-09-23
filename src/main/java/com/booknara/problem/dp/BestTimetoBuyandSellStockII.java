package com.booknara.problem.dp;

/**
 * 122. Best Time to Buy and Sell Stock II (Easy)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {
    // T:O(n), S:O(1)
    public int maxProfit(int[] prices) {
        // input check
        if (prices == null || prices.length == 0) return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}

/**
 input check: the value of prices is non-negative
 [7,1,5,3,6,4]
 whenever the current value is higher than the previous value, add the difference
 int profit = 0;
 loop 1 ~ n - 1
 if (prices[i] > prices[i - 1]) {
 profit += prices[i] - prices[i - 1];
 }

 return profit
 */