package com.booknara.problem.math;

/**
 * 812. Largest Triangle Area (Easy)
 * https://leetcode.com/problems/largest-triangle-area/
 */
public class LargestTriangleArea {
  public double largestTriangleArea(int[][] points) {
    // input check
    if (points == null) {
      return 0.0;
    }

    double res = 0.0;
    for (int i = 0; i < points.length - 2; i++) {
      for (int j = i + 1; j < points.length - 1; j++) {
        for (int k = j + 1; k < points.length; k++) {
          res = Math.max(res, getTriangleAreaGeometry(points[i], points[j], points[k]));
        }
      }
    }

    return res;
  }

  // https://www.mathopenref.com/coordtrianglearea.html
  public double getTriangleAreaGeometry(int[] p1, int[] p2, int[] p3) {
    return Math.abs(p1[0] * (p2[1] - p3[1])
        + p2[0] * (p3[1] - p1[1])
        + p3[0] * (p1[1] - p2[1])) / 2.0;
  }
}
