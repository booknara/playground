package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller (Medium)
 * https://leetcode.com/problems/3sum-smaller/
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        // input check, nums.length >= 3
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;  // no need to check i or less than i
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    // All the indexes are answers btw j and k
                    res += r - l;
                    // increase
                    l++;
                } else {
                    // decrease
                    r--;
                }
            }
        }

        return res;
    }
}
