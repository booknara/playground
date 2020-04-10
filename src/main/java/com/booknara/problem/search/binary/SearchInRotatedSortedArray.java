package com.booknara.problem.search.binary;

/**
 * 33. Search in Rotated Sorted Array (Medium)
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) /2;
            if (target == nums[m]) {
                return m;
            }

            //System.out.println(nums[m]);
            if (nums[l] <= nums[m]) {
                // Pivot is larger than the first element (non-rotated array)
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // Pivot is smaller than the first element (non-rotated array)
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
