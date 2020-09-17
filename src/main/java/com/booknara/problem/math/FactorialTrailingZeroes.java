package com.booknara.problem.math;

/**
 * 172. Factorial Trailing Zeroes (Easy)
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {
    // T:O(logn), S:O(1)
    public int trailingZeroes(int n) {
        if (n <= 0) return 0;

        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }

        return res;
    }
}
/**
 n = 5
 1*2*3*4*5 = 120 -> 1
 1*2*3*4*5*6*7*8*9 = 362880 -> 1
 1*2*3*4*5*6*7*8*9*10 = 3628800 -> 2
 */