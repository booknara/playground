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
                // No need to update if the coin is bigger than amount
                if (coins[j] <= i) {
                    // Find the minimum value between the previous number of denomination
                    // and the number which subtracts coin value from amount and then add 1
                    // Key point : "memo[i - coins[j]] + 1"
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[amount] > amount ? -1 : memo[amount];
    }

    public int coinChangeTopdown(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) {
            return 0;
        }

        return coinChangeHelper(coins, amount, new int[amount]);
    }

    private int coinChangeHelper(int[] coins, int remainingAmount, int[] count) {
        if (remainingAmount < 0) {
            return -1;
        }

        if (remainingAmount == 0) {
            return 0;
        }

        if (count[remainingAmount - 1] != 0) {
            return count[remainingAmount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int c: coins) {
            int res = coinChangeHelper(coins, remainingAmount - c, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        count[remainingAmount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remainingAmount - 1];
    }
}
