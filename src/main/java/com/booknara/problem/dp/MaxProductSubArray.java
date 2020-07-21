package com.booknara.problem.dp;

/**
 * 152. Maximum Product Subarray (Medium)
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubArray {
    // T:O(n), S:O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int totalMax, positiveMax, negativeMax;
        if (nums[0] < 0) {
            negativeMax = nums[0];
            positiveMax = 0;
        } else {
            negativeMax = 0;
            positiveMax = nums[0];
        }

        totalMax = Math.max(positiveMax, negativeMax);
        for (int i = 1; i < nums.length; i++) {
            int temp = positiveMax;
            positiveMax = Math.max(nums[i], Math.max(temp * nums[i], negativeMax * nums[i]));
            negativeMax = Math.min(nums[i], Math.min(temp * nums[i], negativeMax * nums[i]));

            totalMax = Math.max(totalMax, positiveMax);
        }

        return totalMax;
    }
}
