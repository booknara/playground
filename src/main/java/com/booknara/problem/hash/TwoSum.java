package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum (Easy)
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
  // T:O(n), S:O(n)
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    // Key: remaining value, value: index
    for (int i = 0; i < nums.length; i++) {
      //System.out.println(nums[i]);
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      }

      map.put(target - nums[i], i);
    }

    return null;
  }
}
