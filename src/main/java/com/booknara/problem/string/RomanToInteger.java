package com.booknara.problem.string;

/**
 * 13. Roman to Integer (Easy)
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    // T:O(n), S:O(1)
    public int romanToInt(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'M': res += 1000;
                break;
                case 'D': res += 500;
                    break;
                case 'C':
                    // extra
                    if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                        // CD = 400
                        res += 400;
                        i++;
                    } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                        // CM = 900
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                    break;
                case 'L': res += 50;
                    break;
                case 'X':
                    // extra
                    if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                        // XL = 40
                        res += 40;
                        i++;
                    } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                        // XC = 90
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                    break;
                case 'V': res += 5;
                    break;
                case 'I':
                    if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                        // IV = 4
                        res += 4;
                        i++;
                    } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                        // IX = 9
                        res += 9;
                        i++;
                    } else {
                        res += 1;
                    }
                    break;
                default:
                    // invalid input
                    break;
            }
        }

        return res;
    }
}
