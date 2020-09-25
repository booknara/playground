package com.booknara.problem.array;

/**
 * 896. Monotonic Array (Easy)
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {
    // T:O(n), S:O(1)
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;

        boolean ascending = true;
        boolean descending = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                ascending = false;
            }

            if (A[i - 1] > A[i]) {
                descending = false;
            }
        }

        return ascending || descending;
    }

    // T:O(n), S:O(1)
    public boolean isMonotonic1(int[] A) {
        // input check
        if (A == null || A.length <= 1) return true;

        // 0: un-determined, -1: decreasing, 1: increasing
        int indicator = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                continue;
            }

            if (A[i - 1] < A[i]) {
                if (indicator == -1) return false;
                // increasing
                indicator = 1;
            } else {
                if (indicator == 1) return false;
                // decreasing
                indicator = -1;
            }
        }

        return true;
    }
}
