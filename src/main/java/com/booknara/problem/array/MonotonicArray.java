package com.booknara.problem.array;

/**
 * 896. Monotonic Array (Easy)
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {
    // T:O(n), S:O(1)
    public boolean isMonotonic(int[] A) {
        int indicator = 0;  // 0: undeterminded, 1: ascending, -1: descending
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                // ascending/descending, both allow equal case with the previous one
                continue;
            }

            switch (indicator) {
                case 0:
                    // assign 1, -1
                    if (A[i] < A[i - 1]) {
                        indicator = -1;  // descending
                    } else {
                        indicator = 1;  // ascending
                    }
                    break;
                case -1:
                    // should be descending
                    if (A[i] > A[i - 1]) {
                        return false;
                    }
                    break;
                case 1:
                    // should be ascending
                    if (A[i] < A[i - 1]) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
