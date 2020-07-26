package com.booknara.problem.dp;

/**
 * 718. Maximum Length of Repeated Subarray (Medium)
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class MaximumLengthOfRepeatedSubarray {
    // T:O(n^2), S:O(n)
    public int findLength(int[] A, int[] B) {
        int max = 0;

        int[] dp = new int[B.length + 1];
        for (int i = A.length; i >= 1; i--) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j - 1] = dp[j] + 1;
                    max = Math.max(max, dp[j - 1]);
                } else {
                    dp[j - 1] = 0;  // Note: need to reset to '0'
                }
            }
        }

        return max;
    }

    // T:O(n^2), S:O(n^2)
    public int findLength1(int[] A, int[] B) {
        int max = 0;

        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

}
