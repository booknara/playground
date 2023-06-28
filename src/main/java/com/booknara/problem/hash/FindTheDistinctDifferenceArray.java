package com.booknara.problem.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 2670. Find the Distinct Difference Array (Easy)
 * https://leetcode.com/problems/find-the-distinct-difference-array
 */
public class FindTheDistinctDifferenceArray {
  // T:O(n), S:O(n)
  public int[] distinctDifferenceArray(int[] nums) {
    if (nums.length == 1) {
      return new int[] { 1 };
    }

    int prefix[] = new int[nums.length];
    int suffix[] = new int[nums.length];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
      prefix[i] = set.size();
    }

    set.clear();
    for (int j = nums.length - 1; j >= 0; j--) {
      set.add(nums[j]);
      suffix[j] = set.size();
    }

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - 1) {
        res[i] = prefix[i];
      } else {
        res[i] = prefix[i] - suffix[i + 1];
      }
    }

    return res;
  }
}
