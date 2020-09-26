package com.booknara.problem.dp;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock IV (Hard)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIV {
    // T:O(n*k), S:O(1)
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        if (k >= n / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];

        //      [3, 2, 6,5]
        // b:[f,-2,-2]
        // s:[0, 4, 4]
        for(int price : prices){
            for(int i = 1; i < k + 1; i++){
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k];
    }
}
/**
 buy = Math.max(buy, sell - p);
 sell = Math.max(sell, buy + p);
 */