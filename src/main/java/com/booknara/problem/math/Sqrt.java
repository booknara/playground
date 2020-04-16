package com.booknara.problem.math;

/**
 * 69. Sqrt(x) (Easy)
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    // Binary search, O(n)
    public int mySqrt(int x) {
        if (x < 2) return x;

        int l = 2, r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            // long typy casting (edge case: 2147395599)
            long num = (long) m * m;
            if (num == x) return m;

            if (num < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r;
    }

    // Babylonian method to find the square root
    public int mySqrt1(int n) {
        if (n < 2) return n;

        /*We are using n itself as initial approximation This can definitely be improved */
        double x = n;
        double y = 1;

        // e decides the accuracy level
        double precision = 0.000001;
        while (x - y > precision) {
            x = (x + y) / 2;
            y = n / x;
        }
        return (int) x;
    }
}
