package com.booknara.problem.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. Pascal's Triangle II (Easy)
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        // input check
        if (rowIndex == 0) return Collections.singletonList(1);

        List<Integer> res = new ArrayList<>();
        int[][] dp = new int[2][rowIndex + 1];
        dp[1][0] = 1;
        int k = 0;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                int left = j == 0 ? 0 : dp[k ^ 1][j - 1];
                int right = dp[k ^ 1][j];
                dp[k][j] = left + right;
            }
            k ^= 1;
        }

        for (int n: dp[k ^ 1]) {
            res.add(n);
        }

        return res;
    }
}
