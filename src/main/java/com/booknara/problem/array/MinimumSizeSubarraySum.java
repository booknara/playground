package com.booknara.problem.array;

/**
 * 209. Minimum Size Subarray Sum (Medium)
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= s) {
                // System.out.println(i);
                while (j <= i) {
                    minLen = Math.min(minLen, i - j + 1);
                    sum = sum - nums[j];
                    j++;
                    if (sum < s) {
                        break;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
