package com.booknara.problem.dc;

import java.util.List;

/**
 * Leftmost Column with at Least a One
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
 */
public class LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0);
        int col = list.get(1);

        int i = 0, j = col - 1;
        int res = -1;
        while (i <= row - 1 && j >= 0) {
            //System.out.println(i + "," + j);
            if (binaryMatrix.get(i, j) == 0) {
                i++;
            } else {
                res = j;
                j--;
            }
        }

        return res;
    }

     // This is the BinaryMatrix's API interface.
     // You should not implement it, or speculate about its implementation
     interface BinaryMatrix {
          int get(int x, int y);
          List<Integer> dimensions();
     };
}
