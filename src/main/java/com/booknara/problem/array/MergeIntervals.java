package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet code : 56. Merge Intervals (Medium)
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int s = -1;
        int e = -1;
        for (int i = 0; i < intervals.length; i++) {
            // System.out.println(intervals[i][0] + ", " + intervals[i][1]);
            if (i == 0) {
                s = intervals[i][0];
                e = intervals[i][1];
                continue;
            }

            if (e >= intervals[i][0]) {
                e = Math.max(e, intervals[i][1]);
            } else {
                ans.add(new int[] {s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }

        ans.add(new int[] {s, e});
        return ans.toArray(new int[ans.size()][]);
    }
}
