package com.booknara.problem.bit;

/**
 * 191. Number of 1 Bits (Easy)
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    // T:O(1), S:O(1)
    public int hammingWeight(int n) {
        if (n == 0) return 0;

        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }

        return res;
    }

    public int hammingWeight1(int n) {
        if (n == 0) return 0;

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }

        return res;
    }


}
