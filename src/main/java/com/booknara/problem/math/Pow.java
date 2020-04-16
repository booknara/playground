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
    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }

        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) != 0)
                ret *= x;
            x = x * x;
            n = n >> 1;
        }
        return ret;
    }
}
