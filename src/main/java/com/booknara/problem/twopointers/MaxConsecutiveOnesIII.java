package com.booknara.problem.twopointers;

/**
 * 1004. Max Consecutive Ones III (Medium)
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    // T:O(n), S:O(1)
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int graceK = K;
        int max = 0;
        while (r < A.length) {
            if (A[r] == 1 || graceK > 0) {
                if (A[r] == 0) graceK--;
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                // else case means A[l] is 0 and no more graceK
                // to find 0 to move forward with graceK
                while (A[l] != 0) {
                    l++;
                }

                l++;
                graceK++;
            }
        }

        return max;
    }
}
