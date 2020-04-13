package com.booknara.problem.array;

/**
 * 1060. Missing Element in Sorted Array (Medium)
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 */
public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1] - 1;
            if (gap == 0) {
                continue;
            }

            if (gap - k >= 0) {
                // passed
                return nums[i - 1] + k;
            } else {
                k = k - gap;
            }
        }

        return nums[nums.length - 1] + k;
    }
}
