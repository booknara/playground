package com.booknara.problem.twopointers;

/**
 * 923. 3Sum With Multiplicity (Medium)
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */
public class ThreeSumWithMultiplicity {
    // T:O(n), S:O(1)
    public int threeSumMulti(int[] A, int target) {
        // input check 3 <= A.length <= 3000

        final int MOD = 1_000_000_007;
        long[] count = new long[101]; // 0 <= A[i] <= 100
        for (int n: A) {
            count[n]++;
        }

        long res = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;

                if (count[i] * count[j] * count[k] == 0) continue;

                if (i == j && j == k) {
                    res += count[i] * (count[j] - 1) * (count[k] - 2) / 6;
                } else if (i == j && j != k) {
                    res += count[i] * (count[j] - 1) / 2 * count[k];
                } else if (j < k) {
                    res += count[i] * count[j] * count[k];
                }

                res %= MOD;
            }
        }

        return (int) res;
    }
}
