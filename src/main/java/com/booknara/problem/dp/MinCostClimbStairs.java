package com.booknara.problem.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 746. Min Cost Climbing Stairs (Easy)
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbStairs {
    // T:O(n), S:O(1), Bottom-up DP
    public int minCostClimbingStairs(int[] cost) {
        int pp = cost[0];
        int p = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = Math.min(pp, p) + cost[i];
            pp = p;
            p = temp;
        }

        return Math.min(pp, p);
    }

    // T:O(n), S:O(n), Bottom-up DP
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    // Time complexity: O(n), Space complexity: O(n), Top down DP + memoization
    private Map<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }
        memo.clear();
        return Math.min(getStairCost(cost, cost.length - 1), getStairCost(cost, cost.length - 2));
    }

    private int getStairCost(int[] cost, int index) {
        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return cost[0];
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // Main function : F(i) = min(F(i-1), F(i-2)) + cost[i]
        int value = Math.min(getStairCost(cost, index - 1), getStairCost(cost, index - 2)) + cost[index];
        memo.put(index, value);

        return value;
    }
}
