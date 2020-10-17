package com.booknara.problem.dp;

/**
 * 303. Range Sum Query - Immutable (Easy)
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class Immutable1DNumArray {
    int[] dp;
    // T:O(n), S:O(n)
    public Immutable1DNumArray(int[] nums) {
        int m = nums.length;
        dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    // T:O(1), S:O(1)
    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
