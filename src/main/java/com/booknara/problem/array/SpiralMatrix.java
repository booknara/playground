package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix (Medium)
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
  // T:O(n^2), S:O(1)
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res;
    }

    int i = 0, j = 0;
    int imin = 1, jmin = 0;
    int imax = matrix.length - 1;
    int jmax = matrix[0].length - 1;
    int direction = 0;
    while (res.size() < matrix.length * matrix[0].length) {
      res.add(matrix[i][j]);
      if (direction == 0) {
        // left to right
        if (j == jmax) {
          direction = 1;
          jmax--;
          i++;
        } else {
          j++;
        }
      } else if (direction == 1) {
        // top to bottom
        if (i == imax) {
          direction = 2;
          imax--;
          j--;
        } else {
          i++;
        }
      } else if (direction == 2) {
        // right to left
        if (j == jmin) {
          direction = 3;
          jmin++;
          i--;
        } else {
          j--;
        }
      } else {
        // bottom to top
        if (i == imin) {
          direction = 0;
          imin++;
          j++;
        } else {
          i--;
        }
      }
    }

    return res;
  }

  int[][] dirs = new int[][]{
      {0, 1}, // j max and turn
      {1, 0}, // i max and turn
      {0, -1}, // i min and turn
      {-1, 0} // j min and turn
  };

  // T:O(n*m), S:O(1)
  public List<Integer> spiralOrder1(int[][] matrix) {
    // edge case
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return res;

    int i = 0;
    int output = matrix.length * matrix[0].length;
    int x = 0, y = 0;
    int dir = 0;
    int left = 0, right = matrix[0].length - 1, top = 1, bottom = matrix.length - 1;
    while (i < output) {
      // System.out.println("value: " + matrix[x][y]);
      res.add(matrix[x][y]);
      // check turn
      if (dir == 0 && y == right) {
        right = right - 1;
        dir = (dir + 1) % 4;
      } else if (dir == 1 && x == bottom) {
        bottom = bottom - 1;
        dir = (dir + 1) % 4;
      } else if (dir == 2 && y == left) {
        left = left + 1;
        dir = (dir + 1) % 4;
      } else if (dir == 3 && x == top) {
        top = top + 1;
        dir = (dir + 1) % 4;
      }

      x = x + dirs[dir][0];
      y = y + dirs[dir][1];
      i++;
    }

    return res;
  }
}
/**
 * Output: matrix.length * matrix[0].length
 * <p>
 * i range (0 ~ matrix.length - 1)
 * j range (0 ~ matrix[i].length - 1)
 * <p>
 * right = right - 1
 * left = left + 1
 * top = top - 1
 * bottom = bottom + 1
 */
