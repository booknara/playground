package com.booknara.problem.string;

/**
 * Perform String Shifts
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        if (s == null || s.length() == 0 || shift.length == 0) {
            return s;
        }

        int total = 0;
        for (int[] i: shift) {
            if (i[0] == 0) {
                total -= i[1];
            } else if (i[0] == 1) {
                total += i[1];
            }
        }

        // negative total : left shift, positive total : right shift
        if (Math.abs(total) % s.length() == 0) {
            return s;
        }

        StringBuilder builder = new StringBuilder(s);
        if (total < 0) {
            // left shift
            total = Math.abs(total);
            for (int i = 0; i < total; i++) {
                char c = builder.charAt(0);
                builder.delete(0, 1).append(c);
            }
        } else {
            // right shift
            for (int i = 0; i < total; i++) {
                char c = builder.charAt(builder.length() - 1);
                builder.delete(builder.length() - 1, builder.length()).insert(0, c);
            }
        }

        return builder.toString();
    }
}
