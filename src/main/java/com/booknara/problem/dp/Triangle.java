package com.booknara.problem.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle (Medium)
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    // input: list of list integer
    // output: the minimum path sum(integer)
    // T:O(n^2), S:O(N^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        // input check
        if (triangle == null || triangle.size() == 0) return 0;

        int k = 1;
        int[][] memo = new int[2][triangle.size()];
        Arrays.fill(memo[0], Integer.MAX_VALUE);
        Arrays.fill(memo[1], Integer.MAX_VALUE);
        memo[k][0] = triangle.get(0).get(0);
        k ^= 1;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int min = j - 1 >= 0 ? Math.min(memo[k ^ 1][j - 1], memo[k ^ 1][j]) : memo[k ^ 1][j];
                memo[k][j] = triangle.get(i).get(j) + min;
            }

            k ^= 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i: memo[k ^ 1]) {
            min = Math.min(min, i);
        }

        return min;
    }
}
