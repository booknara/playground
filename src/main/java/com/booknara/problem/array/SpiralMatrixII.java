package com.booknara.problem.array;

/**
 * 59. Spiral Matrix II (Medium)
 * https://leetcode.com/problems/spiral-matrix-ii
 */
public class SpiralMatrixII {
  int[][] dirs = new int[][] {
      {0, 1},
      {1, 0},
      {0, -1},
      {-1, 0}
  };

  // T:O(n^2), S:O(1)
  public int[][] generateMatrix(int n) {
    int[][] data = new int[n][n];

    int left = 0, right = data[0].length - 1, top = 1, bottom = data.length - 1;
    int i = 0, j = 0;
    int dir = 0;
    for (int k = 0; k < n * n; k++) {
      data[i][j] = k + 1;
      if (dir % 4 == 0) {
        if (j == right) {
          dir++;
          right--;
        }
      } else if (dir % 4 == 1) {
        if (i == bottom) {
          dir++;
          bottom--;
        }
      } else if (dir % 4 == 2) {
        if (j == left) {
          dir++;
          left++;
        }
      } else if (dir % 4 == 3) {
        if (i == top) {
          dir++;
          top++;
        }
      }

      i = i + dirs[dir % 4][0];
      j = j + dirs[dir % 4][1];
    }

    return data;
  }
}
