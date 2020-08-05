package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix (Medium)
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    // T:O(n^2), S:O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int i = 0, j = 0;
        int imin = 1, jmin = 0;
        int imax = matrix.length - 1;
        int jmax = matrix[0].length - 1;
        int direction = 0;
        while (res.size() < matrix.length * matrix[0].length) {
            res.add(matrix[i][j]);
            if (direction == 0) {
                // left to right
                if (j == jmax) {
                    direction = 1;
                    jmax--;
                    i++;
                } else {
                    j++;
                }
            } else if (direction == 1) {
                // top to bottom
                if (i == imax) {
                    direction = 2;
                    imax--;
                    j--;
                } else {
                    i++;
                }
            } else if (direction == 2) {
                // right to left
                if (j == jmin) {
                    direction = 3;
                    jmin++;
                    i--;
                } else {
                    j--;
                }
            } else {
                // bottom to top
                if (i == imin) {
                    direction = 0;
                    imin++;
                    j++;
                } else {
                    i--;
                }
            }
        }

        return res;
    }
}
