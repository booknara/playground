package com.booknara.problem.dp;

/**
 * Leet code: 53 (Easy)
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    // Time complexity: O(n), Space complexity: O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int total = max;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + max, nums[i]);
            total = Math.max(total, max);
        }

        return total;
    }

    // Time complexity: O(n), Space complexity: O(n)
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }
}
