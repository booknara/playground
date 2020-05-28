package com.booknara.problem.bit;

/**
 * 338. Counting Bits (Medium)
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {
    // T:O(n), S:(n)
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // res[x] = res[x & x - 1] + 1. e.g res[3](11) = res[2= 3(11) & 2(10)] + 1
            res[i] = res[i & i - 1] + 1;
            // res[i] = getBits(i);
        }

        return res;
    }

    // T:O(n), S:(n)
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        if (num == 0) return res;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // even number e.g. 4(100) = 4/2 = 2(10) because 2 << 1 == 4 (same of the value which left shift 1
                res[i] = res[i / 2];
            } else {
                // odd number e.g. 3(11) = 2(10) + 1
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }

    private int getBits(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }

            n = n >> 1;
        }

        return res;
    }

}
