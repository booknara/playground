package com.booknara.problem.math;

/**
 * 263. Ugly Number (Easy)
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {
    // T:O(logn), S:O(1)
    public boolean isUgly(int num) {
        if (num <= 0) return false;

        if (num == 1) return true;

        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;

        return num == 1;
    }
}
