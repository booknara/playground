package com.booknara.problem.search.binary;

/**
 * 33. Search in Rotated Sorted Array (Medium)
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    // T:O(logn), S:O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                // ascending (no pivot)
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // pivot inside
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
