package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number (Medium)
 * https://leetcode.com/problems/valid-triangle-number/
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        // input check
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[i] < nums[l] + nums[r]) {
                    //System.out.println(nums[l] + "," + nums[r] + "," + nums[i]);
                    res += r - l;
                    r--;
                } else {
                    // nums[i] + nums[l] <= nums[r]
                    l++;
                }
            }
        }

        return res;
    }
}
