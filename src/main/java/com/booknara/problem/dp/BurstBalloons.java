package com.booknara.problem.dp;

/**
 * Leet code : 312. Burst Balloons (Hard)
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {
    // Time complexity: O(n^3), Space complexity: O(n^2)
    public int maxCoins(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int n = nums.length + 2;
        int[] newNums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        newNums[0] = 1;
        newNums[n - 1] = 1;

        // left : row, right: column
        // for example, memo[0][2] -> the max value for [a, b, c]
        int[][] memo = new int[n][n];

        return dp(memo, newNums, 0, n - 1);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans,
                    dp(memo, nums, left, i)
                            + nums[left] * nums[i] * nums[right]
                            + dp(memo, nums, i, right));
        }

        memo[left][right] = ans;

        return ans;
    }
}
