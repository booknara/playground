package com.booknara.problem.twopointers;

/**
 * 1004. Max Consecutive Ones III (Medium)
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    // T:O(n), S:O(1)
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) return 0;

        int l = 0, r = 0;
        int max = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                K--;

                while (K < 0) {
                    if (A[l] == 0) {
                        K++;
                    }
                    l++;
                }
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
