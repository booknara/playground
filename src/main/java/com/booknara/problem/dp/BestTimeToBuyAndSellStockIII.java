package com.booknara.problem.dp;

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
buy = Math.max(buy, buy - p);
sell = Math.max(sell, buy + p);
 */
