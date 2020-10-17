package com.booknara.problem.dp;

/**
 * 307. Range Sum Query - Mutable
 * https://leetcode.com/problems/range-sum-query-mutable/
 */
public class Mutable1DNumArray {
    int[] dp;
    int[] nums;
    public Mutable1DNumArray(int[] nums) {
        this.nums = nums;
        int m = nums.length;
        dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        int prev = nums[i];
        int diff = val - prev;
        // only impact i and next index
        for (int j = i + 1; j < dp.length; j++) {
            dp[j] += diff;
        }
        // need to update the value for checking previous value later
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }

}
