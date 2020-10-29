package com.booknara.problem.math;

/**
 * 29. Divide Two Integers (Medium)
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    // O(logn), left shift operator
    public int divide(int dividend, int divisor) {
        // input check, edge case
        // divisor != 0
        // dividend, divisor range between Integer.MIN_VALUE and Integer.MAX_VALUE
        if (dividend == 0) return 0;

        int quotient = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == Integer.MIN_VALUE) return 1;
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
            dividend += Math.abs(divisor);
            quotient++;
        }

        boolean negative = false;
        if (dividend < 0 && divisor > 0) negative = true;
        if (dividend > 0 && divisor < 0) negative = true;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend - divisor >= 0) {
            int accum = divisor, count = 1;
            while (dividend - accum > accum) {
                accum = accum << 1;
                count = count << 1;
            }
            dividend -= accum;
            quotient += count;
        }

        return negative ? -quotient : quotient;
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
