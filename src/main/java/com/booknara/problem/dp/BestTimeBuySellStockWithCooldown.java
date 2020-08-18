package com.booknara.problem.dp;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown (Medium)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeBuySellStockWithCooldown {
    // T:O(n), S:O(1), DP with memory optimization
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int buy = -prices[0];
        int preSell = 0;
        int sell = 0;

        for (int i = 2; i <= prices.length; i++) {
            buy = Math.max(buy, preSell - prices[i - 1]);
            preSell = sell;
            sell = Math.max(sell, buy + prices[i - 1]);
        }

        return sell;
    }

    // T:O(n), S:O(n), DP
    public int maxProfit1(int[] prices) {
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[0] = Integer.MIN_VALUE;
        // sell[0] = 0;

        for (int i = 1; i < prices.length + 1; i++) {
            if (i > 1) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            } else {
                buy[i] = -prices[i - 1];
            }

            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
        }

        return sell[prices.length];
    }
}

/**
 Input check: the value of prices is non-negative
 Inupt: [1,2,3,0,2]
 Output: 3 (1 -> 2, cooldown, 0 -> 2) = 1 + 2

 profit = sell + (-buy)

 int[] buy = new int[prices.length + 1];
 int[] sell = new int[prices.length + 1];

 loop i from 1 ~ (n - 1)
 if (i > 1) {
 buy[i] = max(buy[i - 1], sell[i - 2] - prices[i - 1]);
 } else {
 buy[i] = -prices[i - 1];
 }

 sell[i] = max(sell[i - 1], buy[i - 1] + prices[i - 1]);
 [       1,  2,  3, 0,3]
 buy : [-MIN, -1, -1, -1, 1, 1]
 sell: [0,     0,  1,  2, 2, 3]

 return sell
 */