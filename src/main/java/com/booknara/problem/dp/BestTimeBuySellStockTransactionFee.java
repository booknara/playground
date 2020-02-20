package com.booknara.problem.dp;

/**
 * Leet code: 714. Best Time to Buy and Sell Stock with Transaction Fee (Medium)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimeBuySellStockTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    public int maxProfitwithSpace(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] hold = new int[n];
        int[] sell = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
            System.out.print("price: " + prices[i]);
            System.out.print(" sell: " + sell[i]);
            System.out.println(" hold: " + hold[i]);
        }

        return sell[n - 1];
    }
}
