package com.booknara.problem.heap;

import java.util.*;

/**
 * Leet code : 759. Employee Free Time (Hard)
 * https://leetcode.com/problems/employee-free-time/
 */
public class EmployeeFreeTime {
    // Time Complexity: O(nlogn), n: the number of schedules
    public List<Interval> employeeFreeTimeUsingHeap(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a1, a2) -> a1.start - a2.start);
        for (List<Interval> list: schedule) {
            pq.addAll(list);
        }

        Interval current = pq.poll();
        while (!pq.isEmpty()) {
            // free time
            if (current.end < pq.peek().start) {
                ans.add(new Interval(current.end, pq.peek().start));
                current = pq.poll();
            } else {
                current.end = current.end > pq.peek().end ? current.end : pq.peek().end;
                pq.poll();
            }
        }

        return ans;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();

        if (schedule == null) {
            return ans;
        }

        List<Schedule> time = new ArrayList<>();
        for (List<Interval> list: schedule) {
            for (Interval i: list) {
                time.add(new Schedule(i.start, 1));
                time.add(new Schedule(i.end, -1));
            }
        }

        Collections.sort(time, Comparator.comparingInt(Schedule::getTime));
        int height = 0;
        int start = 0;
        for (int i = 0; i < time.size(); i++) {
            if (i == 0) {
                height += time.get(i).meeting;
                continue;
            }
            if (start != 0) {
                int end = time.get(i).time;
                if (start != end) {
                    ans.add(new Interval(start, end));
                }

                start = 0;
            }

            height += time.get(i).meeting;
            if (height == 0) {
                start = time.get(i).time;
            }
        }

        return ans;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    class Schedule {
        int time;
        int meeting;

        Schedule(int time, int meeting) {
            this.time = time;
            this.meeting = meeting;
        }

        public int getTime() {
            return time;
        }
    }
}
