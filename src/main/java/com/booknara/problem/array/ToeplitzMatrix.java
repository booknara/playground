package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 766. Toeplitz Matrix (Easy)
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class ToeplitzMatrix {
    // T:O(m*n), S:O(1)
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // compare i - 1, j - 1
                if (matrix[i - 1][j - 1] != matrix[i][j]) return false;
            }
        }

        return true;
    }

    // Follow-up problem
    // T:O(m*n), S:O(m)
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> buffer = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            buffer.add(matrix[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // compare i - 1, j - 1
                if (buffer.get(j - 1) != matrix[i][j]) return false;
            }
            buffer.remove(buffer.size() - 1);   // delete the last index
            buffer.add(0, matrix[i][0]);
        }

        return true;
    }

}
