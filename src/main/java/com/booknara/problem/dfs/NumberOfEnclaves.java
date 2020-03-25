package com.booknara.problem.dfs;

/**
 * 1020. Number of Enclaves (Medium)
 * https://leetcode.com/problems/number-of-enclaves/
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    int res = dfs(A, i, j);
                    //System.out.println(res);
                    if (res > 0) {
                        ans += res;
                    }
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] A, int r, int c) {
        A[r][c] = 0;

        // Left
        int left;
        if (c - 1 < 0) {
            left = -1;
        } else if (A[r][c - 1] == 0) {
            left = 0;
        } else {
            left = dfs(A, r, c - 1);
        }
        // Right
        int right;
        if (c + 1 == A[r].length) {
            right = -1;
        } else if (A[r][c + 1] == 0) {
            right = 0;
        } else {
            right = dfs(A, r, c + 1);
        }
        // Top
        int top;
        if (r - 1 < 0) {
            top = -1;
        } else if (A[r - 1][c] == 0) {
            top = 0;
        } else {
            top = dfs(A, r - 1, c);
        }
        // Bottom
        int bottom;
        if (r + 1 == A.length) {
            bottom = -1;
        } else if (A[r + 1][c] == 0) {
            bottom = 0;
        } else {
            bottom = dfs(A, r + 1, c);
        }

        if (left == -1 || right == -1 || top == -1 || bottom == -1) {
            return -1;
        }

        return 1 + left + right + top + bottom;
    }
}
