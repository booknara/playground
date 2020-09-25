package com.booknara.problem.math;

/**
 * 7. Reverse Integer (Easy)
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    // T:O(n, the number of x's digits), S:O(1)
    public int reverse(int x) {
        int negative = x < 0 ? -1: 1;

        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            int mod = x % 10;
            x /= 10;

            res = res * 10 + mod;
            // if overflow, return 0;
            if (negative * res < Integer.MIN_VALUE
                    || negative * res > Integer.MAX_VALUE) return 0;
        }

        return (int) res * negative;
    }
}
