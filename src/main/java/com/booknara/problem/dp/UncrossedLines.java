package com.booknara.problem.dp;

/**
 * 1035. Uncrossed Lines (Medium)
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class UncrossedLines {
    // T:O(n*m), S:O(n)
    public int maxUncrossedLines(int[] A, int[] B) {
        if (A.length * B.length == 0) return 0;

        int[][] dp = new int[2][B.length + 1];
        int flag = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[flag][j] = dp[flag ^ 1][j - 1] + 1;
                } else {
                    dp[flag][j] = Math.max(dp[flag ^ 1][j], dp[flag][j - 1]);
                }
            }
            flag ^= 1;
        }

        return dp[flag ^ 1][B.length];
    }

    // T:O(n*m), S:O(n*m)
    public int maxUncrossedLines1(int[] A, int[] B) {
        if (A.length * B.length == 0) return 0;

        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[A.length][B.length];
    }

    // T:O(n*m), S:O(n*m), Top-down
    public int maxUncrossedLines3(int[] A, int[] B) {
        if (A.length * B.length == 0) return 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(A, 1, B, 1, dp);
    }

    private int dfs(int[] A, int i, int[] B, int j, int[][] dp) {
        if (i == A.length + 1) return 0;
        if (j == B.length + 1) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (A[i - 1] == B[j - 1]) {
            dp[i][j] = 1 + dfs(A, i + 1, B, j + 1, dp);
        } else {
            dp[i][j] = Math.max(dfs(A, i, B, j + 1, dp), dfs(A, i + 1, B, j, dp));
        }

        return dp[i][j];
    }

}
