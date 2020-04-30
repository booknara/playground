package com.booknara.problem.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 764. Largest Plus Sign (Medium)
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class LargestPlusSign {
    // O(n^2)
    public int orderOfLargestPlusSign(int N, int[][] mines) {
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
