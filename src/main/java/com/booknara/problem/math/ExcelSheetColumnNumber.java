package com.booknara.problem.math;

/**
 * 171. Excel Sheet Column Number (Easy)
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
    // T:O(n), S:O(1)
    public int titleToNumber(String s) {
        // input check, the len of S is bigger than 1
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res += Math.pow(26, len - 1 - i) * (s.charAt(i) - 'A' + 1);
        }

        return res;
    }
}
