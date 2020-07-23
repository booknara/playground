package com.booknara.problem.twopointers;

/**
 * 978. Longest Turbulent Subarray (Medium)
 * https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class LongestTurbulentSubarray {
    // T:O(n), S:(1)
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;

        int max = 1;
        int res1 = 1, res2 = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if ((i & 1) == 0) {
                // even
                if (A[i] > A[i + 1]) {
                    res1 = 1;
                    res2++;
                } else if (A[i] < A[i + 1]) {
                    res1++;
                    res2 = 1;
                } else {
                    res1 = 1;
                    res2 = 1;
                }
            } else {
                // odd
                if (A[i] < A[i + 1]) {
                    res1 = 1;
                    res2++;
                } else if (A[i] > A[i + 1]) {
                    res1++;
                    res2 = 1;
                } else {
                    res1 = 1;
                    res2 = 1;
                }
            }

            max = Math.max(max, Math.max(res1, res2));
        }

        return max;
    }
}
