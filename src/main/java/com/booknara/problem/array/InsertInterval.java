package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval (Hard)
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    // T:O(n), S:O(1)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // input check
        if (newInterval == null) return intervals;

        List<int[]> res = new ArrayList<>();
        // assume intervals data sorted
        for (int[] interval: intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                // non-overlapped
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                // overlapped
                newInterval = new int[] { Math.min(interval[0], newInterval[0]),
                        Math.max(interval[1], newInterval[1])};
            }
        }

        if (newInterval != null) {
            // intervals is empty
            res.add(newInterval);
        }

        int[][] output = new int[res.size()][2];
        // convert List<int[]> to int[][]
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }

        return output;
    }

    // T:O(n), S:O(1)
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        // input check
        if (newInterval == null) return intervals;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval == null || newInterval[1] < interval[0]) {
                // add newInterval and interval
                if (newInterval != null) list.add(newInterval);
                list.add(interval);
                newInterval = null;
            } else if (interval[1] < newInterval[0]) {
                // before reaching newInterval
                list.add(interval);
            } else if (newInterval[0] <= interval[1]) {
                // overlapped
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (newInterval != null) {
            list.add(newInterval);
            newInterval = null;
        }

        int n = list.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
/**
 case 1
 [1,     3]      [6,     9]
 [2      5]

 case 2
 [1,     3]      [6,     9]
 [4      7]

 case 3
 [1,     3]      [6,     9]
 [4 5]

 case 4
 [1,     3]      [6,     9]
 [2              7]

 case 5
 [1,     3]      [6,     9]
 [0                          10]

 Rule #1: check whether interval and new interval are overlappend ()
 not overlapped case or already handled
 interval.end < newInterval.start -> add interval to result (case #3)

 overlapped case
 newInteval.start < interval.end
 new interval = min(interval.start, newInterval.start), max(interval.end, newInterval.end)

 close case
 new interval.end < interval.start
 add new interval and interval to result
 new interval = null
 */