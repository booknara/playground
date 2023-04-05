package com.booknara.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes (Medium)
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
  // T:O(n^2), S:O(1)
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    boolean firstCol = false;
    boolean firstRow = false;
    int m = matrix.length;
    int n = matrix[0].length;
    // Utilize the first row and column as a flag to set 0
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;

          // first row & column is indicator
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // update row & col except for first row and column using indicator
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // first row
    if (firstRow) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    // first column
    if (firstCol) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  // T:O(n^2), S:O(m+n)
  public void setZeroes1(int[][] matrix) {
    // edge case
    if (matrix == null || matrix.length == 0) {
      return;
    }
    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row.add(i);
          col.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (row.contains(i) || col.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  // T:O(n^2), S:O(m*n)
  public void setZeroes2(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int[] row = new int[m];
    int[] col = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = 1;
          col[j] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] == 1 || col[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
