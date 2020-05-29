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
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // store the max profit for each time
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];

        buy[0] = 0;
        buy[1] = -prices[0];
        sell[0] = 0;
        sell[1] = 0;

        for (int i = 2; i <= prices.length; i++) {
            // the max profit to buy[i] is btw buy[i - 1](no transaction) and sell[i - 2] - prices[i - 1](make transaction 2day ago profit + yesterday price to buy(subtract))
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            // the max profit to sell[i] is btw sell[i - 1](no transaction) and buy[i - 1] + prices[i - 1], selling)
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
        }

        return sell[prices.length];
    }
}
