package com.booknara.problem.dc;

import java.util.List;

/**
 * 1428. Leftmost Column with at Least a One (Medium)
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
 */
public class LeftMostColumnWithOne {
    // T:O(n+m), S:O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0);
        int col = list.get(1);

        int res = -1;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (binaryMatrix.get(i, j) == 0) {
                i++;
            } else {
                res = j;
                j--;
            }
        }

        return res;
    }

    // T:O(row*logcol)
    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0);
        int col = list.get(1);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            int l = 0, r = (min != Integer.MAX_VALUE) ? min : col - 1;
            if (binaryMatrix.get(i, r) == 0) continue;

            while (l < r) {
                int m = l + (r - l) / 2;
                if (binaryMatrix.get(i, m) == 1) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            if (binaryMatrix.get(i, r) == 0) {
                r = Integer.MAX_VALUE;
            }

            min = Math.min(min, r);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // This is the BinaryMatrix's API interface.
     // You should not implement it, or speculate about its implementation
     interface BinaryMatrix {
          int get(int x, int y);
          List<Integer> dimensions();
     };
}
