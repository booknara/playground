package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals (Medium)
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    // O(n*logn)
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int res = 0;
        int preS = intervals[0][0];
        int preE = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (preE <= intervals[i][0]) {
                // Case #1
                // non-overlapping
                preS = intervals[i][0];
                preE = intervals[i][1];
            } else if (preE > intervals[i][0]) {
                // Case #2
                // a part overlapped
                res++;
            } else if (preS > intervals[i][0]) {
                // Case #3
                // fully overlapped
                res++;
            } else {
                // System.out.println("missing case?");
            }
            // System.out.print(intervals[i][0] + " ");
            // System.out.println(intervals[i][1]);
        }

        return res;
    }
}
