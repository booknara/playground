package com.booknara.problem.dp;

/**
 * 1504. Count Submatrices With All Ones (Medium)
 * https://leetcode.com/problems/count-submatrices-with-all-ones/
 */
public class CountSubmatricesWithAllOnes {
    // T:O(m^2*n), S:O(m*n)
    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;

        int m = mat.length;
        int n = mat[0].length;
        //int[][] dp = new int[m + 1][n + 1];
        int[][] dp = new int[m][n];

        // preprocessing
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = mat[i][j];
                    continue;
                }

                if (mat[i][j] == 0) {
                    continue;
                }

                // add the previous value
                dp[i][j] = dp[i][j - 1] + mat[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }

                res += dp[i][j];

                int min = dp[i][j];
                // row
                int row = i - 1;
                while (row >= 0) {
                    min = Math.min(min, dp[row][j]);
                    res += min;
                    row--;
                }
            }
        }

        return res;
    }
}
/**
 Input: mat = [[1,0,1],
 [1,1,0],
 [1,1,0]]

 Input value : 0, 1

 rectangle or square
 [[1,0,1],
 [1,1,0],
 [1,1,0]]

 [
 [1,0,1],
 [1,2,0],
 [1,2,0]]

 return value
 [[1,0,2],
 [4,6,0],
 [9,13,0]]


 [1,1,1]
 [1,2,3]
 [1,2+1,3+2+1]
 [1,2,3]

 dp[i][j] = up + left + mat
 */