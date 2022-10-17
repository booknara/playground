package com.booknara.problem.array;

/**
 * 724. Find Pivot Index (Easy)
 * https://leetcode.com/problems/find-pivot-index/
 */
public class FindPivotIndex {
  // T:O(n), S:O(1)
  public int pivotIndex(int[] nums) {
    // input check nums.length >= 1
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    int result = -1;
    // left prefix sum
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      // rightSum = sum - leftSum - nums[i]
      if (leftSum == (sum - leftSum - nums[i])) return i;
      leftSum += nums[i];
    }

    return result;
  }

  public int pivotIndex1(int[] nums) {
    if (nums == null || nums.length < 3) {
        return -1;
    }

    int[] sum = new int[nums.length];
    sum[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
        sum[i] = nums[i] + sum[i + 1];
    }

    int left = 0;
    for (int i = 0; i < nums.length; i++) {
        left = left + nums[i];
        if (left == sum[i]) {
            return i;
        }
    }

    return -1;
  }
}
