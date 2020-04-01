package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 986. Interval List Intersections (Medium)
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int lengthA = A.length;
        int lengthB = B.length;
        while (i < lengthA && j < lengthB) {
            int s = Math.max(A[i][0], B[j][0]);
            int e = Math.min(A[i][1], B[j][1]);

            if (s <= e) {
                res.add(new int[]{s, e});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    // O(nlogn)
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        // Input validation
        List<Integer> list = new ArrayList<>();
        for (int[] i: A) {
            list.add(i[0]);
            list.add(-i[1]);
        }
        for (int[] i: B) {
            list.add(i[0]);
            list.add(-i[1]);
        }

        Collections.sort(list, (s, e) -> {
            return Math.abs(s) - Math.abs(e);
        });

        List<int[]> res = new ArrayList<>();
        int inc = 0;
        Integer s = null;
        // int s = 0;
        for (int i: list) {
            //System.out.println(i);
            if (s != null && ((s < 0 && Math.abs(s) == i) || inc == 2)) {
                System.out.println(s + "," + i);
                res.add(new int[]{Math.abs(s), Math.abs(i)});
            }

            if (i >= 0) {
                inc++;
            } else {
                inc--;
            }

            s = i;
        }

        return res.toArray(new int[0][]);
    }
}
