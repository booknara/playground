package com.booknara.problem.search.binary;

/**
 * 153. Find Minimum in Rotated Sorted Array (Medium)
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    // T:O(logn), S:O(1)
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] < nums[r]) return nums[l];

            // e.g. [2,1]
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[r];
    }

    public int findMin1(int[] nums) {
        // input check 0, 1 edge case handling
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            // early detection
            if (m - 1 >= 0 && nums[m - 1] > nums[m]) return nums[m];

            if (nums[l] <= nums[m]) {
                // sorted area
                if (nums[m] > nums[r]) {
                    l = m + 1;  // not pivot area
                } else {
                    r = m - 1;  // pivot area
                }
            } else {
                // pivot area
                r = m - 1;
            }
        }

        return nums[l];
    }

}
