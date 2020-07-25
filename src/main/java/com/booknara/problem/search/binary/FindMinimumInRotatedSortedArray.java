package com.booknara.problem.search.binary;

/**
 * 153. Find Minimum in Rotated Sorted Array (Medium)
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    // T:O(logn), S:O(1)
    public int findMin(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        // not rotated, pivot is 0 index
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                // pivot is at most left index
                break;
            }

            // add '=' because of [2, 1] edge case
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
