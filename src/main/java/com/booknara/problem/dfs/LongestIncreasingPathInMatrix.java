package com.booknara.problem.dfs;

import java.util.Arrays;

/**
 * 329. Longest Increasing Path in a Matrix (Hard)
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInMatrix {
    // T:O(n^2), S:O(n^2)
    public int longestIncreasingPath(int[][] matrix) {
        // input check
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(path[i], -1);
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] == -1) {
                    path[i][j] = dfs(matrix, path, i, j);
                }

                max = Math.max(max, path[i][j]);
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int[][] path, int r, int c) {
        // base case
        if (r < 0 || c < 0 || r == matrix.length || c == matrix[0].length) {
            return 0;
        }

        if (path[r][c] != -1) {
            return path[r][c];
        }

        // left
        int left = 0;
        if (c > 0 && matrix[r][c] < matrix[r][c - 1]) {
            left = dfs(matrix, path, r, c - 1);
        }

        // right
        int right = 0;
        if (c < matrix[0].length - 1 && matrix[r][c] < matrix[r][c + 1]) {
            right = dfs(matrix, path, r, c + 1);
        }
        // up
        int up = 0;
        if (r > 0 && matrix[r][c] < matrix[r - 1][c]) {
            up = dfs(matrix, path, r - 1, c);
        }
        // down
        int down = 0;
        if (r < matrix.length - 1 && matrix[r][c] < matrix[r + 1][c]) {
            down = dfs(matrix, path, r + 1, c);
        }

        path[r][c] = getMax(left, right, up, down) + 1;

        return path[r][c];
    }

    public int getMax(int m1, int m2, int m3, int m4) {
        return Math.max(m1, Math.max(m2, Math.max(m3, m4)));
    }
}
