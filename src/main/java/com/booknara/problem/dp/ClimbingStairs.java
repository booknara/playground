package com.booknara.problem.dp;

/**
 * 70. Climbing Stairs (Easy)
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    // T:O(n), S:O(1)
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }
}
