package com.booknara.problem.math;

/**
 * 50. Pow(x, n) (Medium)
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    // Recursive
    public double myPow(double x, int n) {
        return n < 0 ? 1 / pow(x, -n) : pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double temp = pow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    // Iterative
    // T:O(logn), S:O(1)
    public double myPow1(double x, int n) {
        // input check
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x == 1 || n == 1) return x;

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            x *= x;
            N = N >> 1;
        }

        return res;
    }
}
