package com.booknara.problem.twopointers;

/**
 * 11. Container With Most Water (Medium)
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
  // T:O(n), S:O(1)
  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int l = 0, r = height.length - 1;
    int max = 0;
    while (l < r) {
      int w = r - l;
      int h = Math.min(height[l], height[r]);
      max = Math.max(max, w * h);
      // left or right move which is smaller height between current ones because the taller one should keep
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return max;
  }
}
