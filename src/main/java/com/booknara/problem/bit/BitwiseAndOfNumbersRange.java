package com.booknara.problem.bit;

/**
 * 201. Bitwise AND of Numbers Range (Medium)
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class BitwiseAndOfNumbersRange {
    // Brian Kernighan's Algorithm
    public int rangeBitwiseAnd(int m, int n) {
        // input clarification, m is equal to or bigger than n
        if (m == 0 && n == 0) return 0;

        while (m < n) {
            // When we do AND bit operation between number and number-1,
            // the rightmost bit of one in the original number would be turned off
            // (from one to zero).
            n = n & (n - 1);
        }

        return m & n;
    }

    // find common prefix binary using right shift
    public int rangeBitwiseAnd1(int m, int n) {
        // input clarification, m is equal to or bigger than n
        if (m == 0 && n == 0) return 0;

        if (m == n) return m;

        int count = 0;
        while (m > 0 && n > 0) {
            m = m >> 1;
            n = n >> 1;
            count++;
            if (m == 0 && n == 0) {
                return 0;
            }
            // 6(0110) & 7 (0111) -> common prefix binary is (0110)
            if (m == n) {
                return m << count;
            }
        }

        return 0;
    }
}
