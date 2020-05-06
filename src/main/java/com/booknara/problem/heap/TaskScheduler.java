package com.booknara.problem.heap;

import java.util.*;

/**
 * 621. Task Scheduler (Medium)
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    // 05/06/2020 version
    // T: O(n * m), S:O(n), n: the number of tasks, m: interval
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: tasks) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        // No need Task name.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int v = pq.poll();
                    if (v != 1) {
                        list.add(v - 1);
                    }
                } else if (list.isEmpty()) {
                    // finish because pq is empty and no remaining task
                    return time;
                }

                time++;
            }

            pq.addAll(list);
        }

        return time;
    }

    // 03/10/2020 version
    public int leastInterval1(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int times = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    list.add(maxHeap.poll());
                }
            }

            for (int num: list) {
                if (num - 1 > 0) {
                    maxHeap.add(num - 1);
                }
            }

            times += maxHeap.isEmpty() ? list.size() : n + 1;
        }

        return times;
    }
}
