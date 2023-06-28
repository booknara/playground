package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661. First Completely Painted Row or Column (Medium)
 * https://leetcode.com/problems/first-completely-painted-row-or-column
 */
public class FirstCompletelyPaintedRowOrColumn {
  // T:O(m*n), S:O(m*n)
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    Map<Integer, Point> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        map.put(mat[i][j], new Point(i, j));
      }
    }

    int[] row = new int[m];
    int[] col = new int[n];
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      if (map.containsKey(num)) {
        Point p = map.get(num);
        row[p.i]++;
        col[p.j]++;

        if (row[p.i] == n || col[p.j] == m) {
          return i;
        }
      }
    }

    return -1;
  }

  class Point {
    int i;
    int j;
    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
