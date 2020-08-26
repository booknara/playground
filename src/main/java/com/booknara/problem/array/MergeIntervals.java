package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
/**
 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]

 [1,2],[1,3] = [1,Math.max(2,3)]
 [1,2],[3,4] = []
 [1,3],[2,4] = [1,4]
 [1,4],[2,3]
 */
