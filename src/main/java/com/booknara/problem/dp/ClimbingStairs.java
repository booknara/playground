package com.booknara.problem.dp;

/**
 * 70. Climbing Stairs (Easy)
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    // T:O(n), S:O(1)
    public int climbStairs(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
// dp[0] = 1
// dp[1] = 1
// dp[2] = dp[1] + dp[0] = 2
// dp[3] = dp[1] + dp[2] = 3
// dp[i] = dp[i-1] + dp[i - 2]
// ...
// dp[n] = dp[n - 1] + dp[n - 2]