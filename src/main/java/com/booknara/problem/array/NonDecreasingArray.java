package com.booknara.problem.array;

/**
 * 665. Non-decreasing Array (Easy)
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {
    // T:O(n), S:O(1)
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 2) return true;

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }

            count++;
            if (count > 1) return false;

            // there are two options to change (nums[i - 1] or nums[i])
            if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                nums[i - 1] = nums[i];
            } else {
                nums[i] = nums[i - 1];
            }
        }

        return true;
    }
}
