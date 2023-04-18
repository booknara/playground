package com.booknara.problem.math;

/**
 * 836. Rectangle Overlap (Easy)
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {
  // T:O(1), S:O(1)
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    // overlap means a rectangle (width * height)
    // width (x), 0/2 AND height (y), 1/3
    return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
        && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
  }
}
