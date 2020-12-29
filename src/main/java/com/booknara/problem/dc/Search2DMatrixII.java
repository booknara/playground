package com.booknara.problem.dc;

/**
 * 240. Search a 2D Matrix II (Medium)
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrixII {
    // T:O(n+m), S:O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            // System.out.print(row + ",");
            // System.out.print(col + " ");
            // System.out.println(matrix[row][col]);
            if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
