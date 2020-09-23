package com.booknara.problem.dp;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee (Medium)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimeBuySellStockTransactionFee {
    // T:O(n), S:O(1)
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;

        int profit = 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int p: prices) {
            // buy = max(buy, sell - p) -> the existing profit - p
            // profit = buy + p;
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, buy + p - fee);
        }

        return sell;
    }
}

/**
 Input : positive integer, fee >= 0
 prices = [1, 3, 2, 8, 4, 9], fee = 2

 profit = selling price + (-buying price) - fee

 buy = Integer.MIN_VALUE;
 sell = 0;
 buy  = max(buy,  sell - prices[i]);
 sell = max(sell, prices[i] + buy - fee);

 prices = [1, 3, 2, 8, 4, 9], fee = 2
 buy : -1, -1, -1, -1, 1, 1
 sell:  0,  0, -1,  5, 5, 8

 return sell;
 */