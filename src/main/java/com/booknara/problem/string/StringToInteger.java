package com.booknara.problem.string;

/**
 * 8. String to Integer (atoi) (Medium)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    // T:O(n), S:O(1)
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        str = str.trim();
        int sign = 1;
        // preprocessing
        int i = 0;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        long num = 0L;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            char c = str.charAt(i);
            num = num * 10 + c - '0';

            // overflow check
            if (num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return sign * (int) num;
    }
}
