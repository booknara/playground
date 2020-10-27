package com.booknara.problem.graph;

import java.util.*;

/**
 * 743. Network Delay Time (Medium)
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t: times) {
            if (!graph.containsKey((t[0])))
                graph.put(t[0], new ArrayList<>());

            graph.get(t[0]).add(new int[] {t[1], t[2]});
        }

        // Min heap based on distance
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[] {0, K});

        // Key: Destination, Value: min distance
        Map<Integer, Integer> dist = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;

            dist.put(node, d);
            if (graph.containsKey(node)) {
                for (int[] t: graph.get(node)) {
                    int nei = t[0], d2 = t[1];
                    if (!dist.containsKey(nei)) {
                        heap.offer(new int[] {d + d2, nei});
                    }
                }
            }
        }

        if (dist.size() != N) return -1;

        int max = 0;
        for (int d: dist.values()) {
            max = Math.max(max, d);
        }
        return max;
    }

    // T:O(n^2 + eloge - using heap), S:O(n + e)
    public int networkDelayTime1(int[][] times, int N, int K) {
        // input check
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time: times) {
            int s = time[0];
            int t = time[1];
            int w = time[2];
            List<int[]> list = graph.getOrDefault(s, new ArrayList<>());
            list.add(time);
            graph.put(s, list);
        }

        // min-heap(time, target)
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> {
            // based on time
            return Integer.compare(t1[0], t2[0]);
        });
        pq.offer(new int[] {0, K});

        int max = 0;
        // Target, max time to reach
        Map<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            // [1,1], [1,3]
            int[] info = pq.poll();
            int time = info[0];
            int target = info[1];

            if (map.containsKey(target)) continue; // BFS: no need to continue because of adding the time later

            map.put(target, time);
            max = Math.max(max, time);

            if (graph.containsKey(target)) {
                List<int[]> list = graph.get(target);
                for (int[] arr: list) {
                    // time spent + time to go, target
                    pq.offer(new int[] {arr[2] + time, arr[1]});
                }
            }
        }

        return map.size() == N ? max : -1;
    }
}
