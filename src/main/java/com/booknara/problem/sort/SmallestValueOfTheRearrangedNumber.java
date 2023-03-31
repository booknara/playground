package com.booknara.problem.sort;

import java.util.Arrays;

/**
 * 2165. Smallest Value of the Rearranged Number (Medium)
 * https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
 */
public class SmallestValueOfTheRearrangedNumber {
  // T:O(nlogn), S:O(1)
  public long smallestNumber(long num) {
    // edge case
    if (num >= -9 && num <= 9) {
      return num;
    }

    boolean positive = num > 0;
    if (!positive) num = -1 * num;
    char[] nums = new String("" + num).toCharArray();
    Arrays.sort(nums);  // ascending sort
    if (positive) {
      // positive
      int n = 0;
      for (int i = 0; i < nums.length; i++) {
        char c = nums[i];
        if (c != '0') {
          n = i;
          break;
        }
      }

      // swap the first index value with the first non-zero value
      char temp = nums[n];
      nums[n] = nums[0];
      nums[0] = temp;
      return Long.parseLong(new String(nums));
    } else {
      // negative
      StringBuilder builder = new StringBuilder(new String(nums));
      return -1 * Long.parseLong(builder.reverse().toString());
    }
  }
}
/**
 7605 -> 0567 -> 7650
 asc sort -> reverse
 310 -> 013 -> 103

 3010 -> 0013 -> 1003
 312 -> 123 -> 103
 10 -> 01
 */
