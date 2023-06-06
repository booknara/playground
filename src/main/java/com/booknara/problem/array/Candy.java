package com.booknara.problem.array;

import java.util.Arrays;

/**
 * 135. Candy (Hard)
 * https://leetcode.com/problems/candy
 */
public class Candy {
  // T:O(n), S:O(n)
  public int candy(int[] ratings) {
    // input check
    if (ratings == null || ratings.length == 0) return 0;

    int n = ratings.length;
    int[] left = new int[n];
    Arrays.fill(left, 1);
    int[] right = new int[n];
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        right[i] = right[i + 1] + 1;
      }
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res += Math.max(left[i], right[i]);
    }

    return res;
  }
}
