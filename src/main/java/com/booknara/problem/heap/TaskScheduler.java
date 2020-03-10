package com.booknara.problem.heap;

import java.util.*;

/**
 * 621. Task Scheduler (Medium)
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
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
