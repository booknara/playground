package com.booknara.problem.bit;

/**
 * 190. Reverse Bits (Easy)
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
    // T:O(1), S:O(1)
    public int reverseBits(int n) {
        if (n == 0) return 0;

        // input : 00000010100101000001111010011100
        // mask using d & c
        // 32/2 = 16
        // 1111 1111 1111 1111 0000 0000 0000 0000 | 0000 0000 0000 0000 1111 1111 1111 1111
        n = n >>> 16 | n << 16;
        // 16/2 = 8
        n = (n & 0xFF00FF00) >>> 8 | (n & 0x00FF00FF) << 8;
        // 8/2 = 4
        // 1111 0000 1111 0000 1111 0000 1111 0000 | 0000 1111 0000 1111 0000 1111 0000 1111
        n = (n & 0xF0F0F0F0) >>> 4 | (n & 0x0F0F0F0F) << 4;
        // 4/2 = 2
        // 1100 1100 1100 1100 1100 1100 1100 1100 | 0011 0011 0011 0011 0011 0011 0011 0011
        n = (n & 0xCCCCCCCC) >>> 2 | (n & 0x33333333) << 2;
        // 2/2 = 1
        // 1010 1010 1010 1010 1010 1010 1010 1010 | 0101 0101 0101 0101 0101 0101 0101 0101
        n = (n & 0xAAAAAAAA) >>> 1 | (n & 0x55555555) << 1;

        return n;
    }

    // T:O(1), S:O(1)
    public int reverseBits1(int n) {
        if (n == 0) return 0;

        // input : e.g. 00000010100101000001111010011100
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            //System.out.print(temp);
            res |= temp;
            n = n >> 1;

            if (i != 31) {
                // except the last digit
                res = res << 1;
            }
        }

        return res;
    }
}
