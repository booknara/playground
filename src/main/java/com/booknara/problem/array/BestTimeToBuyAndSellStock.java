package com.booknara.problem.array;

/**
 * 121. Best Time to Buy and Sell Stock (Easy)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    // T:O(n), S:O(1)
    public int maxProfit(int[] prices) {
        // input check
        if (prices == null || prices.length == 0) return 0;
        // input : all the values of prices are non-negative

        int buy = Integer.MIN_VALUE, sell = 0;
        for (int p:prices) {
            buy = Math.max(buy, -p);
            sell = Math.max(sell, buy + p);
        }

        return sell;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;

        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            max = Math.max(max, prices[i] - low);
        }

        return max;
    }

}

/**
 input : all the values of prices are non-negative
 prices: [7,1,5,3,6,4]
 profit = sell - buy = sell + (-buy)
 int buy = Integer.MIN_VALUE, sell = 0;
 loop 0 ~ n - 1
 buy = Math.max(buy, -prices[i]);
 sell = Math.max(sell, prices[i] + buy);

 return sell;
 */
