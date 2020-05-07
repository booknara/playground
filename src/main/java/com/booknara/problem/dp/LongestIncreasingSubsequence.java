package com.booknara.problem.dp;

/**
 * 300. Longest Increasing Subsequence (Medium)
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int total = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            // After ith finishes, it comes up the ith max IS(if an array is descending order, max = 0)
            dp[i] = max + 1;
            total = Math.max(total, dp[i]);
        }

        return total;
    }
}
