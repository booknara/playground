package com.booknara.problem.heap;

import java.util.*;

/**
 * 621. Task Scheduler (Medium)
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    // T: O(n * m), S:O(n), n: the number of tasks, m: interval
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int[] bucket = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            bucket[tasks[i] - 'A']++;
        }

        // max heap
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e2.n, e1.n);
        });

        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) {
                pq.offer(new Element((char)('A' - i), bucket[i]));
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            List<Element> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (pq.isEmpty() && list.isEmpty()) {
                    return res;
                }

                if (!pq.isEmpty()) {
                    Element e = pq.poll();
                    e.n--;
                    if (e.n > 0) {
                        list.add(e);
                    }
                }

                res++;
            }

            pq.addAll(list);
        }

        return res;
    }

    static class Element {
        char c;
        int n;

        Element(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }

    // 05/06/2020 version
    // T: O(n * m), S:O(n), n: the number of tasks, m: interval
    public int leastInterval1(char[] tasks, int n) {
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
    public int leastInterval2(char[] tasks, int n) {
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
