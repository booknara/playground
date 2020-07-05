package com.booknara.problem.dp;

/**
 * 313. Super Ugly Number (Medium)
 * https://leetcode.com/problems/super-ugly-number/
 */
public class SuperUglyNumber {
    // T:O(n*m), S:(n+m)
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[pointers[j]] * primes[j]);
            }

            dp[i] = min;

            for (int j = 0; j < primes.length; j++) {
                if (min == dp[pointers[j]] * primes[j]) {
                    pointers[j]++;
                }
            }

        }

        return dp[n - 1];
    }
}
