package com.booknara.problem.array;

/**
 * 1480. Running Sum of 1d Array (Easy)
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumOf1dArray {
  // T:O(n), S:O(1)
  public int[] runningSum(int[] nums) {
    // input check, nums.length <= 1
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        continue;
      }

      nums[i] = nums[i] + nums[i - 1];
    }
    return nums;
  }
}
/*
input = [1,2,3,4]
        [1,3,6,10]
        nums[i] = nums[i] + nums[i - 1]
output = [1,3,6,10]
*/
