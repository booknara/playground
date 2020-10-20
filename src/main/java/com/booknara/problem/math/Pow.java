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
        if (x == 0) return x;
        if (n == 0) return 1;
        if (n == 1) return x;

        // negative handling
        long N = n;
        if (n < 0) {
            N = -n;
            x = 1 / x;
        }

        double res = 1.0;
        while (N != 0) {
            // two cases
            if ((N & 1) == 1) res = res * x;
            x = x * x;
            N = N >>> 1;
        }

        return res;
    }
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        if (n == 1) return x;

        long num = n;
        if (n < 0) {
            num = -n;
            x = 1 / x;
        }

        // x = 2.0
        double res = 1.0;
        while (num != 0) {
            if ((num & 1) == 1) {
                res *= x;
            }
            x *= x;
            num = num >>> 1;
        }

        return res;
    }
}
/**
 Input:
 x = 2.00000
 n = 10
 (10)
 1.0 * (2.0 * 2.0) = 4.0
 4.0 * (4.0 * 4.0) = 16.0
 16.0 * 16.0 = 4.0 * 256 = 1024;
 Output: 1024.00000
 */