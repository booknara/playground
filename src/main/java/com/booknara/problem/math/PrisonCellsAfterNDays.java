package com.booknara.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 957. Prison Cells After N Days (Medium)
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class PrisonCellsAfterNDays {
    // Time complexity O(2^n), n: the length of input array
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N == 0) {
            return cells;
        }

        Map<String, Integer> seen = new HashMap<>();
        StringBuilder origin = new StringBuilder();
        for (int c: cells) {
            origin.append(c);
        }

        while (N > 0) {
            //System.out.println(N);
            if (seen.containsKey(origin.toString())) {
                N %= seen.get(origin.toString()) - N;
            }

            seen.put(origin.toString(), N);
            if (N >= 1) {
                N--;
                origin = updateCell(origin);
            }
        }

        return getCellArray(origin);
    }

    private int[] getCellArray(StringBuilder builder) {
        int[] res = new int[builder.length()];
        for (int i = 0; i < builder.length(); i++) {
            res[i] = Character.getNumericValue(builder.charAt(i));
        }

        return res;
    }

    private StringBuilder updateCell(StringBuilder source) {
        StringBuilder target = new StringBuilder();
        int len = source.length();
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                target.append('0');
            } else {
                target.append(getCell(source, i));
            }
        }

        return target;
    }

    private char getCell(StringBuilder builder, int i) {
        char pre = builder.charAt(i - 1);
        char next = builder.charAt(i + 1);
        if ((pre == '0' && next == '0') || (pre == '1' && next == '1')) {
            return '1';
        }

        return '0';
    }

    // Straight forward way(Time exceed if input is
    // [1,0,0,1,0,0,1,0]
    // 1000000000
    public int[] prisonAfterNDays1(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N == 0) {
            return cells;
        }

        int[] cells2 = new int[cells.length];
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                // cells -> cells2
                updateCell(cells, cells2);
            } else {
                // cells2 -> cells
                updateCell(cells2, cells);
            }
        }

        return N % 2 == 1 ? cells2 : cells;
    }

    private void updateCell(int[] source, int[] target) {
        int len = source.length;

        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                target[i] = 0;
            } else {
                target[i] = getCell(source, i);
            }
        }
    }

    private int getCell(int[] cells, int i) {
        int pre = cells[i - 1];
        int next = cells[i + 1];
        if ((pre == 0 && next == 0) || (pre == 1 && next == 1)) {
            return 1;
        }

        return 0;
    }
}
