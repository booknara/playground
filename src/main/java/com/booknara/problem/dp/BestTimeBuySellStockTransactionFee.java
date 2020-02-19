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

//             System.out.println(prices[i]);
//             System.out.println("cash: " + cash + "," + "hold: " + hold);
        }

        return cash;
    }
}
