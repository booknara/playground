package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion (Medium)
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    // Better readability
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        int next = -1;
        int cycle = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.size() < numRows) {
                list.add(new StringBuilder());
            }

            list.get(cycle).append(s.charAt(i));
            if (cycle == 0 || cycle == numRows - 1) {
                next = -next;
            }

            cycle += next;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder: list) {
            //System.out.println(builder.toString());
            res.append(builder.toString());
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
