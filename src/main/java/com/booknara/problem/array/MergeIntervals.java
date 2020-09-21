package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 56. Merge Intervals (Medium)
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    // T:O(n*logn) S:O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        if (intervals.length == 1) return intervals;

        // sort ascending
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }

            return i1[0] - i2[0];
        });

        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // not overlapped
            if (prev[1] < cur[0]) {
                list.add(prev);
                prev = cur;
            } else {
                // updated the end
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        // handle the last interval
        list.add(prev);

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int[][] merge1(int[][] intervals) {
        // input check
        if (intervals == null || intervals.length == 0) return new int[0][0];
        if (intervals.length == 1) return intervals;

        // min-heap
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.s == e2.s) Integer.compare(e1.e, e2.e);
            return Integer.compare(e1.s, e2.s);
        });

        for (int[] i: intervals) {
            pq.offer(new Element(i[0], i[1]));
        }

        List<int[]> list = new ArrayList<>();
        Element first = pq.poll();
        int[] interval = new int[2];
        interval[0] = first.s;
        interval[1] = first.e;

        while (!pq.isEmpty()) {
            Element e = pq.poll();
            if (interval[1] < e.s) {
                // not overlapped
                list.add(Arrays.copyOf(interval, interval.length));
                interval[0] = e.s;
                interval[1] = e.e;
            } else {
                // overlapped, merge them
                interval[0] = Math.min(interval[0], e.s);
                interval[1] = Math.max(interval[1], e.e);
            }
        }

        // add the last interval
        list.add(Arrays.copyOf(interval, interval.length));

        // list to array
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    static class Element {
        int s;
        int e;
        Element (int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
/**
 Input: intervals = [[1,3],[2,6],[5,10]]
 [1                10]
   [2     3]
         [3     6]

 [1    3]
    [2    4]
              [7     10]

 Output: [[1,10]]
 1. Min heap by the end range value

 */