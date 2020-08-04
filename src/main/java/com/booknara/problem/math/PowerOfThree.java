package com.booknara.problem.math;

/**
 * 326. Power of Three (Easy)
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {
    // T:O(1), S:O(1)
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        return n == (long) Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
    // T:O(logn), S:O(1)
    public boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        while (n % 3 == 0) {
            n /= 3;
            if (n == 1) return true;
        }

        return false;
    }
}
