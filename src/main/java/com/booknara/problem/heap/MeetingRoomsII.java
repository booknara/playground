package com.booknara.problem.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 253. Meeting Rooms II (Medium)
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {
    // T:O(n), S:O(n)
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) {
            return res;
        }

        Queue<Room> pq = new PriorityQueue<>((r1, r2) -> {
            if (r1.time != r2.time) {
                return Integer.compare(r1.time, r2.time);
            }

            // if time is same, end time is higher priority in order not to increase the number of rooms
            // because they can exit and enter later
            return Integer.compare(r1.start, r2.start);
        });
        for (int[] i: intervals) {
            pq.offer(new Room(1, i[0]));    // start
            pq.offer(new Room(0, i[1]));    // end
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Room r = pq.poll();
            if (r.start == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count--;
            }
        }

        return res;
    }

    static class Room {
        int start;  // end: 0, start: 1
        int time;
        Room(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}
