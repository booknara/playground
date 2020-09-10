package com.booknara.problem.array;

/**
 * 485. Max Consecutive Ones (Easy)
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
    // T:O(n), S:O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        int count = 0;
        for (int n: nums) {
            // two input cases
            if (n == 0) {
                count = 0;  // 0
            } else {
                count++;    // 1
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
