package com.booknara.problem.array;

/**
 * 867. Transpose Matrix (Easy)
 * https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {
    // T:O(N^2), S:O(1)
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int m = A.length;
        int n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    res[i][j] = A[i][j];
                } else {
                    res[j][i] = A[i][j];
                }
            }
        }

        return res;
    }
}
