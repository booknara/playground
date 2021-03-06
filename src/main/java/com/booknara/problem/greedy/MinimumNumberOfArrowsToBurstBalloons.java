package com.booknara.problem.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 452. Minimum Number of Arrows to Burst Balloons (Medium)
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    // T:O(n*logn), S:O(n)
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        // ascending sort by the end value, then start value
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            }

            return p1[1] - p2[1];
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // next start is greater than the current end, then increment count
            if (end < points[i][0]) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }

/**
 if xstart ≤ x ≤ xend.

 Input:
 [[10,16], [2,8], [1,6], [7,12]]
 [1        6]
     [2          8]
             [7          12]
                    [10         16]

 */
    // T:O(n*logn), S:O(n)
    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            }

            return Integer.compare(p1[0], p2[0]);
        });

        for (int[] p : points) {
            pq.offer(p);
        }

        int res = 0;
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            //System.out.println(p[0] + "," + p[1]);
            if (p[0] > end) {
                res++;
                start = p[0];
                end = p[1];
            } else if (p[1] < end) {
                // if the new end is smaller than the existing end,
                // then update the end
                // [1, 16], [2, 3], [4, 5] -> 2 arrow needed
                end = p[1];
            }
        }

        return res;
    }
}
