package com.booknara.problem.dp;

/**
 * 53. Maximum Subarray (Easy)
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    // T:O(n), S:O(1)
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
}
