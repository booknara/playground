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

}
