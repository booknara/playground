package com.booknara.problem.array;

/**
 * 334. Increasing Triplet Subsequence (Medium)
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {
    // T:O(n), S:O(1)
    public boolean increasingTriplet(int[] nums) {
        int k = 3;
        if (nums == null || nums.length < k) {
            return false;
        }

        int[] small = new int[k - 1];
        for (int i = 0; i < k - 1; i++) {
            small[i] = Integer.MAX_VALUE;
        }

        for (int n: nums) {
            int i = 0;
            while (i < small.length && small[i] < n) {
                i++;
            }

            if (i < small.length) {
                small[i] = n;
            } else {
                return true;
            }
        }

        return false;
    }
}
