package com.booknara.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 957. Prison Cells After N Days (Medium)
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class PrisonCellsAfterNDays {
    // T:O(K * min(n, 2^K), K: the number of cells, n: n days
    public int[] prisonAfterNDays(int[] cells, int N) {
        // input check 1 <= N <= 10^9
        StringBuilder builder = new StringBuilder();
        for (int c: cells) {
            builder.append(c);
        }

        Map<String, Integer> seen = new HashMap<>();
        for (int i = N; i >= 1; i--) {
            if (seen.containsKey(builder.toString())) {
                i %= seen.get(builder.toString()) - i;
                //System.out.println("hit : " + i);
            }

            // edge case: the result of modulus is 0
            // e.g. [1,0,0,0,1,0,0,1], 99
            if (i == 0) {
                break;
            }
            seen.put(builder.toString(), i);
            builder = updateCells(builder);
        }

        return getCells(builder);
    }

    public StringBuilder updateCells(StringBuilder builder) {
        StringBuilder res = new StringBuilder();
        String s = builder.toString();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || i == s.length() - 1) {
                res.append("0");
            } else {
                res.append(s.charAt(i - 1) == s.charAt(i + 1) ? "1" : "0");
            }
        }

        return res;
    }

    public int[] getCells(StringBuilder builder) {
        int[] res = new int[builder.length()];
        for (int i = 0; i < builder.length(); i++) {
            res[i] = Character.getNumericValue(builder.charAt(i));
        }

        return res;
    }

    // TLS
    // [1,0,0,1,0,0,1,0]
    // 1000000000
    public int[] prisonAfterNDays1(int[] cells, int N) {
        // input check 1 <= N <= 10^9
        int[][] temp = new int[2][cells.length];
        // System.arraycopy(cells, 0, temp[0], 0, cells.length); // equivalent
        for (int i = 0; i < cells.length; i++) {
            temp[0][i] = cells[i];
        }
        int toggle = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 7) {
                    temp[toggle][j] = 0;
                } else {
                    temp[toggle][j] = temp[toggle ^ 1][j - 1] == temp[toggle ^ 1][j + 1] ? 1 : 0;
                }
            }

            toggle ^= 1;
        }

        return temp[toggle ^ 1];
    }
}
