package com.booknara.problem.bit;

/**
 * 190. Reverse Bits (Easy)
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
    // T:O(1), S:O(1)
    public int reverseBits(int n) {
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
