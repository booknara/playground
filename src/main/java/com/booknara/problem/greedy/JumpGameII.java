package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 45. Jump Game II (Medium)
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    // T:O(n), S:O(1)
    public int jump(int[] nums) {
        // input check
        int n = nums.length;
        if (n < 2) return 0;

        int maxPos = nums[0];
        int maxSteps = nums[0]; // the max steps reachable from current jumps
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            if (maxSteps < i) {
                jumps++;
                maxSteps = maxPos;
            }

            maxPos = Math.max(maxPos, i + nums[i]);
        }

        return jumps;
    }

    // T:O(n^2), S:O(n)
    public int jump1(int[] nums) {
        // input check
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= num; j++) {
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
