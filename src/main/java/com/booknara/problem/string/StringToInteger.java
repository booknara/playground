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

    // T:O(n), S:O(1)
    public int myAtoi1(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        long num = 0L;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                break; // white space btw the start and the end
            }

            if (i == 0) {
                if (c == '+' || c == '-') {
                    if (c == '-') sign = -1;
                    continue;
                }

                if (c == '.') break;

                if (Character.isLetter(c)) return 0;

                num = num * 10 + c - '0';
                continue;
            }

            if (c == '+' || c == '-') {
                break;
            }

            if (c == '.') break;

            if (Character.isLetter(c)) break;

            num = num * 10 + c - '0';

            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return sign * (int) num;
    }
}
