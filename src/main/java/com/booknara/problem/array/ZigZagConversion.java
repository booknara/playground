package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion (Medium)
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    // T:O(n, the length of string), S:O(n, the length of string)
    public String convert(String s, int numRows) {
        // input check
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        // down -> row++
        // up -> row--
        boolean down = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            list.get(row).append(c);
            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder b: list) {
            res.append(b.toString());
        }

        return res.toString();
    }
}
