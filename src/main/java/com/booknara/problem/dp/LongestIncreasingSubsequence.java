package com.booknara.problem.dp;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence (Medium)
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    // T:O(nlogn), S:O(n)
    public int lengthOfLIS(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;

        for (int num: nums) {
            int i = 0, j = size;

            int index = binarySearch(tails, i, j, num);
            tails[index] = num;
            if (index == size) size++;
        }

        return size;
    }

    // start: inclusive end: exclusive
    public int binarySearch(int[] tails, int start, int end, int num) {
        while (start < end) {
            int m = start + (end - start) / 2;
            if (tails[m] < num) {
                start = m + 1;
            } else {
                end = m;
            }
        }

        return start;
    }

    // T:O(n^2), S:O(n)
    public int lengthOfLIS1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int total = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            // After ith finishes, it comes up the ith max IS(if an array is descending order, max = 0)
            dp[i] = max + 1;
            total = Math.max(total, dp[i]);
        }

        return total;
    }

    // T:O(n^2), S:O(n)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // input check
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < num) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
