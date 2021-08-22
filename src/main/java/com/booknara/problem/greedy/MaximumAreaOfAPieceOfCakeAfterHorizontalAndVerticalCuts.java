package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts (Medium)
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    // sort array
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    long maxHeight = 0;
    int height = 0;
    for (int i = 0; i < horizontalCuts.length; i++) {
      maxHeight = Math.max(maxHeight, horizontalCuts[i] - height);
      height = horizontalCuts[i];
    }
    maxHeight = Math.max(maxHeight, h - height);

    long maxWidth = 0;
    int width = 0;
    for (int i = 0; i < verticalCuts.length; i++) {
      maxWidth = Math.max(maxWidth, verticalCuts[i] - width);
      width = verticalCuts[i];
    }
    maxWidth = Math.max(maxWidth, w - width);

    return (int) ((maxHeight * maxWidth) % 1000000007);
  }

}
