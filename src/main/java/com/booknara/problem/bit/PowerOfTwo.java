package com.booknara.problem.bit;

/**
 * 231. Power of Two (Easy)
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {
    // T:O(1), S:T(1)
    public boolean isPowerOfTwo(int n) {
        // negative value -> false
        if (n <= 0) return false;

        return (n & n - 1) == 0;
    }
}
