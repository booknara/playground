package com.booknara.problem.math;

/**
 * 65. Valid Number (Hard)
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    // T:O(n), S:O(1)
    public boolean isNumber(String s) {
        // input check
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean dot = false, exponetial = false, number = false;
        s = s.trim();
        if (s.length() == 0) return false;  // empty string with white space is not valid

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) && c != 'e') {
                // all the alphabets are invalid except 'e'
                return false;
            }

            if (c == ' ') return false;   // invalid if there is white space in the middle
            if (i == s.length() - 1 && !Character.isDigit(c) && !number) {
                return false; // the last character should be number or . with number beforehand(e.g. "3.")
            }

            if (Character.isDigit(c)) {
                number = true;
            } else if (c == '.') {
                // if (!number) return false; // '.' appears with any number before. Note: allows ".1" valid
                if (dot|| exponetial) return false; // afer 'e', floating number is invalid
                dot = true;
            } else if (c == 'e') {
                if (!number) return false; // 'e' appears with any number before
                if (exponetial) return false;   // two times 'e'
                if (i == s.length() - 1) return false;

                // once 'e' appears, '+', '-' can appear again
                number = false;
                exponetial = true;
                dot = false;        // "32.e-80123" is valid
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false; // negative or positive are only allowed at the first or next to 'e'
                }
            }
        }

        return true;
    }
}
