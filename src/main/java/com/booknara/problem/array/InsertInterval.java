package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval (Hard)
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;

        List<int[]> res = new ArrayList<>();
        for (int[] i: intervals) {
            // non-overlapped cases
            if (newInterval == null || i[1] < newInterval[0]) {
                // appearing i before newInterval or already handled newInterval
                res.add(i);
            } else if (newInterval[1] < i[0]) {
                // appearing i after newInterval and wrapped up merging newInterval
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            } else {
                // overlapped cases
                int front = Math.min(i[0], newInterval[0]);
                int back = Math.max(i[1], newInterval[1]);
                newInterval = new int[] {front, back};
            }
        }

        if (newInterval == null) return res.toArray(new int[res.size()][]);
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
