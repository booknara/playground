package com.booknara.problem.search.binary;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K (Easy)
 * https://leetcode.com/problems/two-sum-less-than-k/
 */
public class TwoSumLessThanK {
    // T:O(n*logn), S:O(1)
    public int twoSumLessThanK(int[] A, int K) {
        // input check, the length of A >= 1
        int res = -1;
        if (A.length == 1) return res;

        res = Integer.MAX_VALUE;
        // sort ascending
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        while (l < r) {
            int sum = A[l] + A[r];

            if (sum < K) {
                if (Math.abs(sum - K) < Math.abs(res - K)) {
                    res = sum;
                }
                l++;
            } else {
                r--;
            }
        }

        return res == Integer.MAX_VALUE? -1 : res;
    }
}
