package com.booknara.problem.twopointers;

import java.util.*;

/**
 * 986. Interval List Intersections (Medium)
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    // May 24, 2020 version
    public int[][] intervalIntersection(int[][] A, int[][] B) {
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
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
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
                    res.add(new int[] {b[0], b[1]});
                    j++;
                } else {
                    // case 3) a and b has an intersection partly, b[0] and a[1] is an intersection
                    res.add(new int[] {b[0], a[1]});
                    i++;
                }
            } else {
                // a[0] > b[0]
                if (b[1] < a[0]) {
                    // case 1) not overlapped
                    j++;
                } else if (b[1] > a[1]) {
                    // case 2) a includes b entirely, b is an intersection
                    res.add(new int[] {a[0], a[1]});
                    i++;
                } else {
                    // case 3) a and b has an intersection partly, b[0] and a[1] is an intersection
                    res.add(new int[] {a[0], b[1]});
                    j++;
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    // O(nlogn)
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
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

    // T:O(n*logn), S:O(n + m);
    public int[][] intervalIntersection3(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        if (A.length * B.length == 0) {
            return res.toArray(new int[res.size()][]);
        }

        Queue<Interval> pq = new PriorityQueue<>((i1, i2) -> {
            if (i1.time == i2.time) {
                // i1, i2(false, true), i2, i1(true, false) order
                return Boolean.compare(i2.start, i1.start);
            }
            return Integer.compare(i1.time, i2.time);
        });

        for (int[] i: A) {
            pq.offer(new Interval(true, i[0]));
            pq.offer(new Interval(false, i[1]));
        }

        for (int[] i: B) {
            pq.offer(new Interval(true, i[0]));
            pq.offer(new Interval(false, i[1]));
        }

        int count = 0;
        int prev = 0;
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (count == 2) {
                res.add(new int[] {prev, interval.time});
            }

            if (interval.start) {
                count++;
            } else {
                count--;
            }

            prev = interval.time;
        }

        return res.toArray(new int[res.size()][]);
    }

    static class Interval {
        boolean start; // true: start, false: end
        int time;
        Interval(boolean start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}
