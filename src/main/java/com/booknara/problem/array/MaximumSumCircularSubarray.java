package com.booknara.problem.array;

/**
 * 918. Maximum Sum Circular Subarray (Medium)
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class MaximumSumCircularSubarray {
    // T:O(n), S:O(1)
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = A[0];
        int totalMax = A[0];
        int min = A[0];
        int totalMin = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            // Kadane’s Algorithm
            if (max + A[i] > A[i]) {
                max = max + A[i];
            } else {
                max = A[i];
            }

            totalMax = Math.max(totalMax, max);
            if (min + A[i] < A[i]) {
                min = min + A[i];
            } else {
                min = A[i];
            }
            totalMin = Math.min(totalMin, min);

            sum += A[i];
        }

        // all negative values
        if (sum == totalMin) {
            return totalMax;
        }

        return Math.max(totalMax, sum - totalMin);
    }
}
