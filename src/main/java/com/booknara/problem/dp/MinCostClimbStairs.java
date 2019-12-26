package com.booknara.problem.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet code : 746 (Easy)
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 */
public class MinCostClimbStairs {
    private Map<Integer, Integer> memo = new HashMap<>();

    // Time complexity: O(n), Space complexity: O(n), Top down DP + memoization
    public int minCostClimbingStairs(int[] cost) {
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

    // Time complexity: O(n), Space complexity: O(1), Bottom-up DP
    public int optimizedMinCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int prev = 0, prev2 = 0;
        int value = 0;
        for (int i = 0; i < cost.length; i++) {
            value = Math.min(prev, prev2) + cost[i];
            if (i == cost.length - 1) {
                // Whether the last element or previos element is a minmum value.
                value = Math.min(prev, value);
            }

            prev2 = prev;
            prev = value;
        }

        return value;
    }
}
