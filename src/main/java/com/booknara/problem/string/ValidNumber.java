package com.booknara.problem.string;

/**
 * 65. Valid Number (Hard)
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    // T:O(n), S:O(1)
    public boolean isNumber(String s) {
        // input check
        s = s.trim();
        if (s.length() == 0) return false;

        boolean exp = false, point = false, number = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) && c != 'e') {
                // all the alphabets are invalid except 'e'
                return false;
            }

            if (c == ' ') return false;
            // the last character condition
            if (i == s.length() - 1 && !Character.isDigit(c) && !number) {
                return false;
            }

            if (c >= '0' && c <= '9') {
                number = true;
                // number
            } else if (c == 'e') {
                // exponent
                if (i == s.length() - 1) return false;
                if (!number) return false;
                if (exp) return false;
                exp = true;
                number = false;
            } else if (c == '.') {
                // point
                if (point || exp) return false;
                point = true;
            } else if (c == '-' || c == '+') {
                // sign is only allowed to appear the first or next to exponent
                if (i - 1 < 0 || s.charAt(i - 1) == 'e') continue;
                return false;
            }
        }

        return true;
    }
}
/**
 Decimal number
 1. Number
 2. Positive/Negative sign '+/-'
 3. Exponent e
 4. Decimal point .

 " " -> false
 ".1" -> true
 "." -> false
 "3." -> true
 "0e" -> false
 "13 45" -> false
 */
