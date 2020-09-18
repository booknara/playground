package com.booknara.problem.math;

/**
 * 172. Factorial Trailing Zeroes (Easy)
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {
    // T:O(logn), S:O(1)
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += (n / 5);
            n /= 5;
        }

        return res;
    }
}
/**
 1,2,3,4,5      -> 1
 6,7,8,9,10     -> (2)1
 11,12,13,14,15 -> (3)1
 16,17,18,19,20 -> (4)1
 21,22,23,24,25 -> (6)2

 5 -> 1
 10-> 1
 15 -> 1
 20 -> 1
 25 -> 2

 n / 5
 */