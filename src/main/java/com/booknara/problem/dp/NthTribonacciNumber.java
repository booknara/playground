package com.booknara.problem.dp;

/**
 * 1137. N-th Tribonacci Number (Easy)
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class NthTribonacciNumber {
    // T:O(n), S:O(n)
    public int tribonacci(int n) {
        // input check
        if (n == 0) return 0;
        if (n < 3) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
