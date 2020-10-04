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

    // T:O(n), S:O(1)
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

    // T:O(nlogn), S:O(1)
    public int maxSubArray2(int[] nums) {
        // input check num.length >= 1
        if (nums.length == 1) return nums[0];

        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, right, mid);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = p; i > left - 1; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = p + 1; i < right + 1; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
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