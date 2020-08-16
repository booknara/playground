package com.booknara.problem.array;

/**
 * 123. Best Time to Buy and Sell Stock III (Hard)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {
    // T:O(n), S:O(1)
    public int maxProfit(int[] prices) {
        // input check
        if (prices == null || prices.length == 0) return 0;
        // assume the value of prices is non-negative

        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
        int fs = 0, ss = 0;

        for (int p: prices) {
            fb = Math.max(fb, -p);
            fs = Math.max(fs, fb + p);
            sb = Math.max(sb, fs - p);
            ss = Math.max(ss, sb + p);
        }

        return ss;
    }
}

/**
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete "at most two" transactions.
 Day     1,2,3,4,5,6,7,8
 Input: [3,3,5,0,0,3,1,4]
 Output: 6 (3 + 3)
 Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

 One by one transaction(buy-sell-buy-sell)
 profit = sell + (-buy) (buy then sell)
 fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
 fs = 0, ss = 0;
 loop price[0] -> price[n - 1]
 fb = Math.max(fb, -prices[i]);
 fs = Math.max(fs, fb + prices[i]);
 sb = Math.max(sb, fs - prices[i]);
 ss = Math.max(ss, sb + prices[i]);

 return ss;
 */
