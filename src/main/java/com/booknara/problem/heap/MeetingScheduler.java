package com.booknara.problem.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1229. Meeting Scheduler (Medium)
 * https://leetcode.com/problems/meeting-scheduler/
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        if (slots1 == null || slots1.length == 0
                || slots2 == null || slots2.length == 0) {
            return res;
        }

        PriorityQueue<Time> pq = new PriorityQueue<>((time1, time2) -> {
            if (time1.time != time2.time) {
                return time1.time - time2.time;
            }

            return time1.step - time2.step;
        });
        for (int i = 0; i < slots1.length; i++) {
            if (slots1[i][1] - slots1[i][0] >= duration) {
                pq.offer(new Time(slots1[i][0], -1));
                pq.offer(new Time(slots1[i][1], 1));
            }
        }

        for (int i = 0; i < slots2.length; i++) {
            if (slots2[i][1] - slots2[i][0] >= duration) {
                pq.offer(new Time(slots2[i][0], -1));
                pq.offer(new Time(slots2[i][1], 1));
            }
        }

        int step = 0;
        int last = 0;
        while (!pq.isEmpty()) {
            Time t = pq.poll();
            if (step == -2 && t.time - last >= duration) {
                res.add(last);
                res.add(last + duration);
                break;
            }
            step += t.step;
            last = t.time;
        }

        return res;
    }

    class Time {
        int time;
        // start : -1, end: 1;
        int step;
        Time(int time, int step) {
            this.time = time;
            this.step = step;
        }
    }
}
