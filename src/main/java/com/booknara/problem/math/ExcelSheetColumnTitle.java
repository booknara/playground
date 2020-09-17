package com.booknara.problem.math;

/**
 * 168. Excel Sheet Column Title (Easy)
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
    // T:O(n/26=n), S:O(1)
    public String convertToTitle(int n) {
        if (n == 0) return "";

        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int mod = (n - 1) % 26;

            char c = (char)('A' + (char)(mod));
            builder.append(c);

            n = (n - 1) / 26;
        }

        return builder.reverse().toString();
    }
}
/**
 27 -> AA
 1*26 + 1 = AA
 27 % 26 = 1
 27 / 26 = 1
 1 % 26 = 1
 */