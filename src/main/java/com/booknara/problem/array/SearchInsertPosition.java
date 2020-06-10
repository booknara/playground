package com.booknara.problem.array;

/**
 * 35. Search Insert Position (Easy)
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    // T:O(n), S:O(1)
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }

        return nums.length;
    }
}
