package com.booknara.problem.twopointers;

/**
 * 487. Max Consecutive Ones II (Medium)
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 */
public class MaxConsecutiveOnesII {
    // T:O(n), S:O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        int l = 0, r = 0;
        int k = 1;
        int max = 0;
        while (r < nums.length) {
            if (nums[r] == 0) { // 0
                // decrease k
                k--;
                // move l to right til k == 0
                while (k < 0) {
                    if (nums[l] == 0) {
                        k++;
                    }
                    l++;
                }
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
