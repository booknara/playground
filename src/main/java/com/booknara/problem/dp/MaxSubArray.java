package com.booknara.problem.dp;

/**
 * Leet code: 53 (Easy)
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * sum[i] = max(nums[i], sum[i - 1] + nums[i])
 */
public class MaxSubArray {
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

    // Time complexity: O(n), Space complexity: O(1)
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int prev = nums[0];
        int max = prev;
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(nums[i], prev + nums[i]);
            max = Math.max(max, curr);
            prev = curr;
        }

        return max;
    }
}
