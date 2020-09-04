package com.booknara.problem.array;

/**
 * 283. Move Zeroes (Easy)
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    // T:O(n), S:O(1)
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

    // T:O(n), S:O(1)
    public void moveZeroes1(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return;

        int i = 0, j = 0;   // i = non-zero index, j = looping index
        while (j < nums.length) {
            // Key: move the non-zero value to the front
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
