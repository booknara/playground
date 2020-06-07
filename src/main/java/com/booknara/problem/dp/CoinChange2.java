package com.booknara.problem.dp;

/**
 * 518. Coin Change 2 (Medium)
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange2 {
    // T:O(n^2), S:O(n)
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }

    // T:O(n^2), S:O(n^2)
    public int change1(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j == 0) {
                    // for amount = 0, then 1 because not choosing any coins
                    dp[i][j] = 1;
                    continue;
                }

                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
