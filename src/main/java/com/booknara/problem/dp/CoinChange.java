package com.booknara.problem.dp;

import java.util.Arrays;

/**
 * Leet code : 322 (Medium)
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount == 0) {
            return 0;
        }

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        // Per amount, each coin updates the final result
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - coins[j]]);
                }
            }
        }

        return memo[amount] > amount ? -1 : memo[amount];
    }
}
