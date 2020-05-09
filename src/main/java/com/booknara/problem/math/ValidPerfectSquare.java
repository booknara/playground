package com.booknara.problem.math;

/**
 * 367. Valid Perfect Square (Easy)
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {
    // T:O(log*n), S:O(1)
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        if (num <= 2) return true;

        // should be long type in case of Integer.MAX_VALUE input
        long l = 2, r = num / 2;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long x = m * m;
            if (x == num) {
                return true;
            }

            if (x > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

    // T:O(log*n), S:O(1)
    public boolean isPerfectSquare1(int num) {
        if (num <= 0) return false;
        if (num <= 2) return true;
        int n = 2;
        // should be long type in case of Integer.MAX_VALUE input
        long value = 0;

        // System.out.println(num);
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println((long)Math.pow(46341, 2));
        while (value <= num) {
            value = (long) Math.pow(n, 2);
            if (value == num) {
                return true;
            }
            n++;
        }

        return false;
    }
}
