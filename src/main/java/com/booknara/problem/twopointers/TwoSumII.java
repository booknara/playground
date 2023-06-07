package com.booknara.problem.twopointers;

/**
 * 167. Two Sum II - Input Array Is Sorted (Medium)
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
  // T:(n), S:O(1)
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int l = 0, r = numbers.length - 1;
    while (l < r) {
      if (numbers[l] + numbers[r] == target) {
        res[0] = l + 1;
        res[1] = r + 1;
        break;
      }
      if (numbers[l] + numbers[r] < target) {
        l++;
      } else {
        r--;
      }
    }

    return res;
  }
}
