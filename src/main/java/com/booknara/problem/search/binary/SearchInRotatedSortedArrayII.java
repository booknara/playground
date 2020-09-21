package com.booknara.problem.search.binary;

/**
 * 81. Search in Rotated Sorted Array II (Medium)
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    // T:O(n), S:O(1)
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        // [0,1,2,3,4]
        // [1,3,1,1,1], target = 3;
        int l = 0, r = nums.length - 1; // 0, 4
        while (l <= r) {
            int m = l + (r - l) / 2;    // 2 (1 != 3)
            if (nums[m] == target) return true;

            if (nums[l] < nums[m]) {
                // left part ascending
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;  // 0,1
                } else {
                    l = m + 1;  // [3,4]
                }
            } else if (nums[l] > nums[m]) {
                // right part ascending
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1; // [0,2]
                }
            } else {
                // nums[l] == nums[m], but it doesn't guarantee all the same value btw l and m
                l++;    // T:O(n)
            }
        }

        return false;
    }
}
/**
 Binary Search
 // [1,3,1,1,1], target = 3;
 */