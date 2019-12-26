package com.booknara.problem.dp;

/**
 * Leet code : 152 (Medium)
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class MaxProductSubArray {
    // Time complexity: O(n), Space complexity: O(n)
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int totalMax;
        int negativeMax;
        int positiveMax;
        if (nums[0] < 0) {
            negativeMax = nums[0];
            positiveMax = 0;
            totalMax = positiveMax;
        } else {
            negativeMax = 0;
            positiveMax = nums[0];
            totalMax = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            // nums[i], positiveMax * nums[i], negativeMax * nums[i]
            int temp = positiveMax;
            positiveMax = Math.max(Math.max(nums[i], positiveMax * nums[i]), negativeMax * nums[i]);
            negativeMax = Math.min(Math.min(nums[i], temp * nums[i]), negativeMax * nums[i]);
            totalMax = Math.max(Math.max(totalMax, positiveMax), negativeMax);
        }

        return totalMax;
    }
}
