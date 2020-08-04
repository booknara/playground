package com.booknara.problem.math;

/**
 * 342. Power of Four (Easy)
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {
    // T:O(1), S:O(1)
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        // Power of 2
        if ((num & num - 1) != 0) return false;

        // Power of 4, 0x5 -> 0101
        return (num & 0x55555555) != 0;
    }

    // T:O(logn), S:O(1)
    public boolean isPowerOfFour1(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        while (num % 4 == 0) {
            num /= 4;
            if (num == 1) return true;
        }

        return false;
    }
}
