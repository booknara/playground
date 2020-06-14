package com.booknara.problem.graph;

import com.booknara.problem.common.Pair;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops (Medium)
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
    // T:O(K*n), n: the number of edge, S:O(m), m: the number of vertex
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // input clarification
        if (src == dst) return 0;

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] tmp = Arrays.copyOf(cost, n);
            for (int[] f: flights) {
                int s = f[0], d = f[1], p = f[2];
                if (cost[s] == Integer.MAX_VALUE) {
                    // No need to update the node that doesn't reach out
                    continue;
                }

                if (cost[s] + p < tmp[d]) {
                    tmp[d] = cost[s] + p;
                }
            }

            cost = tmp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        // input clarification
        if (src == dst) return 0;
        // 1. edges to map
        int[][] graph = new int[n][n];
        for (int[] f : flights) {
            graph[f[0]][f[1]] = f[2];
        }

        // origin - key: node, stops, value: cost
        Map<Pair<Integer, Integer>, Long> map = new HashMap<>();
        map.put(new Pair<>(src, 0), 0L);

        long res = Long.MAX_VALUE;
        int stops = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        queue.offer(null);

        while (!queue.isEmpty() && stops < K + 1) {
            Integer v = queue.poll();
            if (v == null) {
                stops++;
                queue.offer(null);
                if (queue.peek() == null) break;
                else continue;
            }

            for (int i = 0; i < n; i++) {
                int price = graph[v][i];
                if (price == 0) {
                    continue;
                }

                long dV = map.getOrDefault(new Pair<>(v, stops), Long.MAX_VALUE);
                long dI = map.getOrDefault(new Pair<>(i, stops + 1), Long.MAX_VALUE);

                if (stops == K && i != dst) {
                    // not update non-dst node
                    continue;
                }

                if (dV + price < dI) {
                    map.put(new Pair<>(i, stops + 1), dV + price);
                    queue.offer(i);

                    if (i == dst) {
                        res = Math.min(res, dV + price);
                    }
                }
            }
        }

        return res == Long.MAX_VALUE ? -1 : (int) res;
    }
}