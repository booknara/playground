package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections (Medium)
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    // Aug 21, 2020 version
    // T:O(n + m), S:O(n + m)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // input check
        if (A == null || B == null
                || A.length * B.length == 0) return new int[][] {};

        int idxA = 0, idxB = 0;
        List<int[]> list = new ArrayList<>();
        while (idxA < A.length && idxB < B.length) {
            int[] e1 = A[idxA];
            int[] e2 = B[idxB];

            // the max of start points
            int max = Math.max(e1[0], e2[0]);
            // the min of end points
            int min = Math.min(e1[1], e2[1]);
            if (max <= min) {
                list.add(new int[] {max, min});
            }

            // compare end value
            if (e1[1] < e2[1]) {
                idxA++;
            } else if (e1[1] > e2[1]) {
                idxB++;
            } else {
                // e1[1] == e2[1]
                // [3,5], [4,5]
                if (e1[0] < e2[0]) {
                    idxA++;
                } else {
                    idxB++;
                }
            }
        }

        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] e: list) {
            res[i++] = e;
        }

        return res;
    }

    // May 24, 2020 version
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        if (A.length * B.length == 0) {
            return res.toArray(new int[res.size()][]);
        }

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] pairA = A[i];
            int[] pairB = B[j];
            // get the overlapped area
            int max = Math.max(pairA[0], pairB[0]);
            int min = Math.min(pairA[1], pairB[1]);
            if (max <= min) {
                res.add(new int[] {max, min});
            }

            if (pairA[1] < pairB[1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    // Apr 9, 2020 version
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        // Input validation handling
        if (A == null || A.length == 0
                || B == null || B.length == 0) {
            return res.toArray(new int[0][]);
        }

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[0] < b[0]) {
                if (a[1] < b[0]) {
                    // case 1) not overlapped
                    i++;
                } else if (a[1] > b[1]) {
                    // case 2) a includes b entirely, b is an intersection
                    res.add(new int[]{b[0], b[1]});
                    j++;
                } else {
                    // case 3) a and b has an intersection partly, b[0] and a[1] is an intersection
                    res.add(new int[]{b[0], a[1]});
                    i++;
                }
            } else {
                // a[0] > b[0]
                if (b[1] < a[0]) {
                    // case 1) not overlapped
                    j++;
                } else if (b[1] > a[1]) {
                    // case 2) a includes b entirely, b is an intersection
                    res.add(new int[]{a[0], a[1]});
                    i++;
                } else {
                    // case 3) a and b has an intersection partly, b[0] and a[1] is an intersection
                    res.add(new int[]{a[0], b[1]});
                    j++;
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
