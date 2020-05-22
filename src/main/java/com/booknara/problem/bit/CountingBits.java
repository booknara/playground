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
        }

        return res;
    }

    // T:O(n), S:(n)
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        if (num == 0) return res;

        res[1] = 1;
        if (num == 1) {
            return res;
        }

        res[2] = 1;
        if (num == 2) {
            return res;
        }

        for (int i = 3; i <= num; i++) {
            if (i % 2 == 0) {
                // even number
                res[i] = res[i / 2];
            } else {
                // odd number
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}
