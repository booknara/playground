package com.booknara.problem.twopointers;

/**
 * 487. Max Consecutive Ones II (Medium)
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 */
public class MaxConsecutiveOnesII {
    // T:O(n), S:O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int graceK = 1;
        int max = 0;
        while (r < nums.length) {
            if (nums[r] == 1 || graceK > 0) {
                if (nums[r] == 0) graceK--;
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                // else case means nums[l] is 0 and no more graceK
                // to find 0 to move forward with graceK
                while (nums[l] != 0) {
                    l++;
                }

                l++;
                graceK++;
            }
        }

        return max;
    }
}
