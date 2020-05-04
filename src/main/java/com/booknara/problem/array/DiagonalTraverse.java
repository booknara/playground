package com.booknara.problem.array;

/**
 * 498. Diagonal Traverse (Medium)
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {
    // T: O(m*n), S: O(1, except result array)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0;
        boolean up = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            if (up) {
                row--;
                col++;
            } else {
                row++;
                col--;
            }

            // Note: should handle "row >= m" and "col >= n" case first
            if (row >= m) { row = m - 1; col += 2; up = !up;}
            if (col >= n) { col = n - 1; row += 2; up = !up;}
            if (row < 0)  { row = 0; up = !up;}
            if (col < 0)  { col = 0; up = !up;}
        }

        return result;
    }
}
