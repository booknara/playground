package com.booknara.problem.bit;

/**
 * 461. Hamming Distance (Easy)
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {
    // T:O(1), S:O(1)
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) {
                res++;
            }
            // Using right shift
            xor = xor >> 1;
        }

        return res;
    }

    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor > 0) {
            res++;

            // Using Brian Kernighan's Algorithm
            xor = xor & (xor - 1);
        }

        return res;
    }

    // T:O(1), S:O(1)
    public int hammingDistance2(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {
            int l = x & 1;
            int r = y & 1;
            if (l != r) {
                res++;
            }
            // shift
            x = x >> 1;
            y = y >> 1;
        }

        return res;
    }

    // T:O(1), S:O(1)
    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
}
