package com.booknara.problem.sort;

import java.util.Arrays;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
  // T:O(nlogn), S:O(1)
  public int minDifference(int[] nums) {
    // input condition (1 <= nums.length <= 105)
    if (nums == null || nums.length < 5) {
      return 0;
    }
    // ascending sort
    Arrays.sort(nums);
    // 0,1,2,3
    int min = Integer.MAX_VALUE;
    int n = 4;
    for (int i = 0; i < n; i++) {
      // i ~ length - 4 + i
      // 0 ~ 4 - 3 + 0
      int start = i;
      int end = nums.length - n + start;
      int difference = nums[end] - nums[start];
      min = Math.min(min, difference);
    }

    return min;
  }
}
/**
 Input: nums = [5,3,2,4]
 0,1,2,3
 2,3,4,5
 Output: 0
 1. two smallest elements -> 4,5
 2. two largest elements -> 2,3
 3. one smallest and one largest element -> 3,4

 Input: nums = [1,5,0,10,14]
 Output: 1
 0,1,5,7,10,14

 // i ~ length - 4 + i
 // i = 0, 0 ~ 1
 // i = 1, 1 ~ 2
 */
