package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * Leet code: 16. 3Sum Closest (Medium)
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k]  == target) {
                    return target;
                }

                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < closest) {
                    closest = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    ans = nums[i] + nums[j] + nums[k];
                }

                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
