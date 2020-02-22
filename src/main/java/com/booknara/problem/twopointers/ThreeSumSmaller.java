package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller (Medium)
 * https://leetcode.com/problems/3sum-smaller/
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    // All the indexes are answers btw j and k
                    ans = ans + k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
