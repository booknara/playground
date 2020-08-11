package com.booknara.problem.array;

/**
 * 974. Subarray Sums Divisible by K (Medium)
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisibleByK {
    // T:O(n), S:(n)
    public int subarraysDivByK(int[] A, int K) {
        // input check
        int[] sums = new int[A.length + 1];
        int sum = 0;
        // prefix sum
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sums[i + 1] = sum;
        }

        int[] mods = new int[K];
        for (int i = 0; i < sums.length; i++) {
            // for negative modules (add + K, then % K)
            mods[(sums[i] % K + K) % K]++;
        }

        int res = 0;
        for (int i = 0; i < mods.length; i++) {
            if (mods[i] >= 2) {
                // nC2
                res += (mods[i] * (mods[i] - 1)) / 2;
            }
        }

        return res;
    }
}
