package com.booknara.problem.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum (Medium)
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    // T:O(n*m), S:(n)
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // sum(p) - sum(n) = target
        // sum(p) + sum(n) = sum(total)
        // sum(p) + sum(n) + sum(p) - sum(n) = target + sum(total);
        // 2*sum(p) = target + sum(total)
        // sum(p) = (target + sum(total)) / 2
        int total = 0;
        for (int n: nums) {
            total += n;
        }

        // too smaller to be S
        if (total < S) return 0;
        // odd number can't get the solution
        if (((total + S) & 1) == 1) return 0;

        // 0/1 knap-sack problem
        int sum = (total + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
    }

    // DFS + Memoization, T:O(l*n, l: a range of sum), S:O(n)
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Key: index + remaining string, Value: the total number of ways
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, S, memo);
    }

    private int dfs(int[] nums, int index, int remaining, Map<String, Integer> memo) {
        if (index == nums.length) {
            if (remaining == 0) return 1;
            else return 0;
        }

        if (memo.containsKey(index + "+" + remaining)) {
            return memo.get(index + "+" + remaining);
        }

        int neg = dfs(nums, index + 1, remaining - nums[index], memo);
        int pos = dfs(nums, index + 1, remaining + nums[index], memo);
        memo.put(index + "+" + remaining, neg + pos);

        return neg + pos;
    }
}
