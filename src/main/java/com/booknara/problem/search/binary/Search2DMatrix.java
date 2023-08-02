package com.booknara.problem.search.binary;

/**
 * Leet code : 74 (Medium)
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 */
public class Search2DMatrix {
  // T:O(log(n*m)
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int r = 0, c = n - 1;
    while (r < m && c >= 0) {
      if (matrix[r][c] == target) {
        return true;
      } else if (matrix[r][c] < target) {
        r++;
      } else {
        c--;
      }
    }

    return false;
  }

  public boolean searchMatrix1(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
      return false;
    }

    int row = matrix.length - 1;
    while (row >= 0) {
      if (matrix[row][0] == target) {
        return true;
      }

      if (target < matrix[row][0]) {
        row--;
      } else {
        int s = 0;
        int e = matrix[0].length - 1;
        while (s <= e) {
          int m = s + (e - s) / 2;
          if (matrix[row][m] == target) {
            return true;
          }

          if (matrix[row][m] < target) {
            s = m + 1;
          } else {
            e = m - 1;
          }
        }

        return false;
      }
    }

    return false;
  }
}
