package com.booknara.problem.sort;

import java.util.Arrays;

/**
 * 252. Meeting Rooms (Easy)
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {
    // T:O(nlogn), S:O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        // input check
        if (intervals == null || intervals.length <= 1) return true;

        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1[1], i2[1]);
        });

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (prev[1] > current[0]) return false;

            prev = current;
        }

        return true;
    }
}
