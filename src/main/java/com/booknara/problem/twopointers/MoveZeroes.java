package com.booknara.problem.twopointers;

/**
 * 283. Move Zeroes (Easy)
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    // T:O(n), S:O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
