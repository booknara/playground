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
  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    map.put(0, -1);
    int sum = 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum >= target) {
        Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(sum - target);
        res = Math.min(i - ceiling.getValue(), res);
      }

      map.put(sum, i);
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }

  // T:(n), S:O(1)
  public int minSubArrayLen1(int target, int[] nums) {
    // input check
    if (nums == null || nums.length == 0) return 0;

    int len = nums.length;
    int[] prefixSum = new int[len];
    int sum = 0;
    int res = Integer.MAX_VALUE;
    int j = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];

      if (sum >= target) {
        while (j <= i) {
          res = Math.min(res, i - j + 1);
          sum -= nums[j];
          j++;
          if (sum < target) {
            break;
          }
        }
      }
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
