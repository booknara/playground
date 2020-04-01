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

        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap point and index
                int temp = nums[i];
                nums[i] = nums[point];
                nums[point] = temp;
                point++;
            }
        }
    }
}
