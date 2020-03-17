package com.booknara.problem.array;

/**
 * 485. Max Consecutive Ones (Easy)
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                count = 0;
            }

            maxCount = count > maxCount ? count : maxCount;
        }

        return maxCount;
    }
}
