package com.booknara.problem.math;

/**
 * 29. Divide Two Integers (Medium)
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    // O(logn), left shift operator
    public int divide(int dividend, int divisor) {
        // input clarification
        // Integer range (-2^31 ~ 2^31-1), -2^31*-1 = 2^31(out of range)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) return dividend;

        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x = 0;
        while (a - b >= 0) {
            // 0 << 1 = 0, 0 + 1 << 1 = 2, 2(10 by binary) + 1 = 3 << 1 = 4;
            for (x = 0; a - (b << x << 1) >= 0; x++);
            // add 2 ^ x to result
            res += 1 << x;
            // subtract a - b * 2^x
            a -= b << x;
        }

        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    // Linear search: Still slow O(n), dividend / divisor
    public int divide1(int dividend, int divisor) {
        // input clarification
        // Integer range (-2^31 ~ 2^31-1), -2^31*-1 = 2^31(out of range)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) return dividend;

        // Use negative value(positive -> negative) because negative range is bigger than positive
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return negative == 1 ? -quotient : quotient;
    }
}
