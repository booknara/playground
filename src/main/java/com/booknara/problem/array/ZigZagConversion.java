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
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        // the number of rows StringBuilder needed
        List<StringBuilder> builders = new ArrayList<>();
        int next = -1;
        // cycle variable decides a dedicated StringBuilder
        int cycle = 0;
        for (int i = 0; i < s.length(); i++) {
            if (builders.size() == i) {
                builders.add(new StringBuilder());
            }

            char c = s.charAt(i);
            builders.get(cycle).append(c);
            // System.out.println(cycle);
            if (cycle == 0 || cycle == numRows - 1) {
                next *= -1;
            }

            cycle += next;
        }

        // append builders
        StringBuilder res = new StringBuilder();
        for (StringBuilder b: builders) {
            res.append(b.toString());
        }

        return res.toString();
    }

    // #1 solution
    public String convert1(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        int cycle = numRows + (numRows - 2);
        for (int i = 0; i < s.length(); i++) {
            int mod = i % cycle;

            if (list.size() < numRows) {
                list.add(new StringBuilder());
            }
            if (mod < numRows) {
                list.get(mod).append(s.charAt(i));
            } else {
                list.get(cycle - mod).append(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder: list) {
            //System.out.println(builder.toString());
            res.append(builder.toString());
        }

        return res.toString();
    }
}
