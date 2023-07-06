package com.booknara.problem.array;

/**
 * 2672. Number of Adjacent Elements With the Same Color (Medium)
 * https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color
 */
public class NumberOfAdjacentElementsWithTheSameColor {
  // T:O(n), S:O(n)
  public int[] colorTheArray(int n, int[][] queries) {
    int count = 0;
    int[] nums = new int[n];
    int[] output = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int[] q = queries[i];
      int idx = q[0];
      int val = q[1];
      // prev
      if (idx > 0) {
        if (nums[idx - 1] == 0) {
          // skip
        } else if (nums[idx - 1] == nums[idx]) {
          if (nums[idx - 1] != val && count > 0) {
            count--;
          }
        } else {
          if (nums[idx - 1] == val) {
            count++;
          }
        }
      }
      // next
      if (idx < n - 1) {
        if (nums[idx + 1] == 0) {
          // skip
        } else if (nums[idx + 1] == nums[idx]) {
          if (nums[idx + 1] != val && count > 0) {
            count--;
          }
        } else {
          if (nums[idx + 1] == val) {
            count++;
          }
        }
      }

      nums[idx] = val;
      output[i] = count;
    }

    return output;
  }
}
