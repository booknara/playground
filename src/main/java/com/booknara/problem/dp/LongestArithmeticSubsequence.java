package com.booknara.problem.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 1027. Longest Arithmetic Subsequence (Medium)
 * https://leetcode.com/problems/longest-arithmetic-subsequence/
 */
public class LongestArithmeticSubsequence {
  // T:O(n^2), S:O(n^2)
  public int longestArithSeqLength(int[] nums) {
    // edge case
    if (nums.length <= 2) {
      return nums.length;
    }
    int max = 2;
    // DP Memoization
    Map<Integer, Integer>[] dp = new HashMap[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = new HashMap();  // key: different, value: the max of length
    }

    for (int i = 1; i < nums.length; i++) {
      int end = nums[i];
      for (int j = 0; j < i; j++) {
        int start = nums[j];
        int d = end - start;

        int len = 2;
        // Find the current max length from previous result(j) and increment length if applicable
        if (dp[j].containsKey(d)) {
          len = dp[j].get(d) + 1;
        }

        dp[i].put(d, len);
        max = Math.max(max, len);
      }
    }

    return max;
  }
}
