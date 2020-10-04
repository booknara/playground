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

    public int maxSubArray1(int[] nums) {
        // input check num.length >= 1
        if (nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        int prefixSum = 0;
        int min = 0;
        for (int n: nums) {
            prefixSum += n;
            max = Math.max(max, prefixSum - min);
            min = Math.min(min, prefixSum);
        }

        return max;
    }
}
/**
 Given an integer array nums, find the contiguous subarray (containing at least one number)
 which has the largest sum and return its sum.
 element = [-2, 1,-3,4,-1,2,1,-5,4]
 max     = [-2, 1,-2,4, 3,5,6, 1,5]
 total.  = [-2, 1, 1,4, 4,5,6, 6,6]
 [4,-1,2,1], res = 6
 */