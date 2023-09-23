package com.booknara.problem.dp;

/**
 * 152. Maximum Product Subarray (Medium)
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubArray {
  // T:O(n), S:O(1)
  public int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int max = 0;
    for (int n: nums) {
      max = Math.max(max, n);
    }
    int curMin = 1;
    int curMax = 1;

    for (int i = 0; i < nums.length; i++) {
      int temp = curMax;
      curMax = Math.max(nums[i], Math.max(temp * nums[i], curMin * nums[i]));
      curMin = Math.min(nums[i], Math.min(temp * nums[i], curMin * nums[i]));
      max = Math.max(max, curMax);
    }

    return max;
  }

  public int maxProduct1(int[] nums) {
    // input check
    if (nums == null || nums.length == 0) return 0;

    int max = Integer.MIN_VALUE;
    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      product = product * nums[i];
      max = Math.max(max, product);
      if (product == 0) {
        product = 1;    // reset
      }
    }

    product = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      product = product * nums[i];
      max = Math.max(max, product);
      if (product == 0) {
        product = 1;    // reset
      }
    }

    return max;
  }
}
/**
 * /**
 * [2,3,-2,4]
 * [-2,-3,2,4]
 * comparision
 * 1. current
 * 2. previous max * current
 * 3. previous low * current
 * max = 1 vs 2 vs 3
 * min = 1 vs 2 vs 3
 * total = total vs max
 */
