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

    // T:O(n*m), S:O(n*m)
    public int longestIncreasingPath1(int[][] matrix) {
        // input check
        if (matrix == null || matrix.length == 0) return 0;

        int totalMax = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] == 0) {
                    path[i][j] = dfs(matrix, true, i, j, i, j, path);
                }
                totalMax = Math.max(totalMax, path[i][j]);
            }
        }

        return totalMax;
    }

    public int dfs(int[][] matrix, boolean init, int preR, int preC, int r, int c, int[][] path) {
        // base case (out of range, already have the path value, descreasing)
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length) return 0;
        if (!init && matrix[preR][preC] >= matrix[r][c]) return 0;
        if (path[r][c] != 0) return path[r][c];

        // four directions
        int left = dfs(matrix, false, r, c, r, c - 1, path) + 1;
        int right = dfs(matrix, false, r, c, r, c + 1, path) + 1;
        int up = dfs(matrix, false, r, c, r - 1, c, path) + 1;
        int down = dfs(matrix, false, r, c, r + 1, c, path) + 1;

        int max = getMax(left, right, up, down);
        path[r][c] = max;

        return max;
    }

    public int getMax(int m1, int m2, int m3, int m4) {
        return Math.max(m1, Math.max(m2, Math.max(m3, m4)));
    }

    int[][] dirs = new int[][] {
            {-1, 0},    // up
            {1, 0},     // down
            {0, -1},    // left
            {0, 1}      // right
    };

    // T:O(n*m), S:O(n*m)
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == -1) {
                    distance[i][j] = getDistance(matrix, distance, true, 0, 0, i, j);
                }

                max = Math.max(max, distance[i][j]);
            }
        }

        return max;
    }

    public int getDistance(int[][] matrix, int[][] distance, boolean start, int prevR, int prevC, int r, int c) {
        // base case
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) return 0;

        if (!start && matrix[prevR][prevC] >= matrix[r][c]) return 0;

        // already got the distance
        if (distance[r][c] != -1) return distance[r][c];

        int max = 0;
        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            int d = getDistance(matrix, distance, false, r, c, newR, newC);
            max = Math.max(max, d + 1);
        }

        distance[r][c] = max;

        return distance[r][c];
    }
/**
 Input: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Output: 4
 Explanation: The longest increasing path is [1, 2, 6, 9].
 */
}
