package com.booknara.problem.array;

/**
 * 283. Move Zeroes (Easy)
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, zero);
                zero++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
