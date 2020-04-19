package com.booknara.problem.array;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 209. Minimum Size Subarray Sum (Medium)
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    // 04/19/2020 version
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(sum - s);
                res = Math.min(i - ceiling.getValue(), res);
            }

            map.put(sum, i);
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 03/17/2020 version
    public int minSubArrayLen1(int s, int[] nums) {
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
