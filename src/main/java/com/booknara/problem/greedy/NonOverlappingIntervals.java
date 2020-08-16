package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals (Medium)
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    // O(n*logn)
    public int eraseOverlapIntervals(int[][] intervals) {
        // input check
        if (intervals == null || intervals.length == 0) return 0;

        // each element of intervals has the only two elements
        // And [x,y] -> x is smaller than y

        // sort by the end value of the element
        Arrays.sort(intervals, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        int res = 0;
        int preS = intervals[0][0];
        int preE = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (preE <= intervals[i][0]) {
                // case #1 (non-overlapping)
                preS = intervals[i][0];
                preE = intervals[i][1];
            } else if (preS < intervals[i][0]) {
                // case #2 (partly overlapping)
                res++;
            } else if (preS >= intervals[i][0]) {
                // case #3 (fully overlapping)
                res++;
            }
        }

        return res;
    }
}

// Given a collection of intervals(length: 2), find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
// [[1,2],[2,3],[3,4],[1,3]]
// 1,2
//   2,3
//     3,4
// 1   3 -> remove the one

// 2 2 2 1 (the number of over-lapping) -> the max value : 2
// result max - 1

// sort by the end value of the element
// [1,2] 1,2
// [1,3] 1,  3
// [2,3]   2,3
// [3,4]     3.4
// there are three cases to compare a pre interval and current interval
// 1. non-overlapping
// [1,2] 1,2
// [2,3]   2,3

// 2. partly overlapping
// [1,3] 1,  3
// [2,4]   2,  4

// 3. fully overlapping
// [1,3] 1,  3
// [1,4] 1,    4
