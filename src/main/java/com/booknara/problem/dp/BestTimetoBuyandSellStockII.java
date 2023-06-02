package com.booknara.problem.dp;

/**
 * 122. Best Time to Buy and Sell Stock II (Medium)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {
  // T:O(n), S:O(1)
  public int maxProfit(int[] prices) {
    // edge case
    if (prices == null || prices.length == 0) return 0;

    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      // whenever the price goes up than before, add it to the profit
      // because the sum of each profit becomes the profit eventually
      // (1,2,3,4,5) = 5 - 1 = 4 vs (2 - 1 = 1, 3 - 2 = 1, 4 - 3 = 1, 5 - 4 = 1)
      int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        profit += diff;
      }
    }

    return profit;
  }
}

/**
 * input check: the value of prices is non-negative
 * [7,1,5,3,6,4]
 * whenever the current value is higher than the previous value, add the difference
 * int profit = 0;
 * loop 1 ~ n - 1
 * if (prices[i] > prices[i - 1]) {
 * profit += prices[i] - prices[i - 1];
 * }
 * <p>
 * return profit
 */
