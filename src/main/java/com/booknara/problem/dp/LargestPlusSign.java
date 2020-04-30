package com.booknara.problem.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 764. Largest Plus Sign (Medium)
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class LargestPlusSign {
    // O(n^2), better performance
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (mines == null || mines.length == 0) {
            return (N + 1) / 2;
        }

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m: mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            int l = 0, r = 0, t = 0, b = 0;
            for (int j = 0, k = N - 1; j < N; j++, k--) {
                // left
                if (grid[i][j] == 0) l = 0;
                else l += 1;
                grid[i][j] = Math.min(grid[i][j], l);

                // right
                if (grid[i][k] == 0) r = 0;
                else r += 1;
                grid[i][k] = Math.min(grid[i][k], r);

                // top
                if (grid[j][i] == 0) t = 0;
                else t += 1;
                grid[j][i] = Math.min(grid[j][i], t);

                // bottom
                if (grid[k][i] == 0) b = 0;
                else b += 1;
                grid[k][i] = Math.min(grid[k][i], b);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }

    // O(n^2)
    public int orderOfLargestPlusSign1(int N, int[][] mines) {
        if (mines == null || mines.length == 0) {
            return (N + 1) / 2;
        }

        Set<Integer> set = new HashSet<>();
        for (int[] m: mines) {
            set.add(m[0] * N + m[1]);
        }

        int max = 0;
        int[][] dp = new int[N][N];
        // row check
        for (int r = 0; r < N; r++) {
            int count = 0;
            // left -> right
            for (int c = 0; c < N; c++) {
                boolean mine = set.contains(r * N + c);
                if (mine) {
                    dp[r][c] = 0;
                    count = 0;
                } else {
                    dp[r][c] = ++count;
                }
            }
            // right -> left
            count = 0;
            for (int c = N - 1; c >= 0; c--) {
                boolean mine = set.contains(r * N + c);
                if (mine) {
                    dp[r][c] = 0;
                    count = 0;
                } else {
                    dp[r][c] = Math.min(dp[r][c], ++count);
                }
            }
        }

        // column check
        for (int c = 0; c < N; c++) {
            int count = 0;
            // top -> bottom
            for (int r = 0; r < N; r++) {
                boolean mine = set.contains(r * N + c);
                if (mine) {
                    dp[r][c] = 0;
                    count = 0;
                } else {
                    dp[r][c] = Math.min(dp[r][c], ++count);
                }
            }
            // bottom -> top
            count = 0;
            for (int r = N - 1; r >= 0; r--) {
                boolean mine = set.contains(r * N + c);
                if (mine) {
                    dp[r][c] = 0;
                    count = 0;
                } else {
                    dp[r][c] = Math.min(dp[r][c], ++count);
                    max = Math.max(max, dp[r][c]);
                }
            }
        }

        return max;
    }
}
