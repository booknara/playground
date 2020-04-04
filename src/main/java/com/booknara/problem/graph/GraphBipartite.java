package com.booknara.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite? (Medium)
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class GraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }

        // 0: not visited, 1: red, 2: blue
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                if (!isBipartite(graph, i, color)) return false;
            }
        }

        return true;
    }

    private boolean isBipartite(int[][] graph, int source, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        color[source] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i: graph[n]) {
                if (color[n] == 1) {
                    if (color[i] == 1) return false;

                    if (color[i] == 0) {
                        queue.add(i);
                        color[i] = 2;
                    }
                } else {
                    if (color[i] == 2) return false;

                    if (color[i] == 0) {
                        queue.add(i);
                        color[i] = 1;
                    }
                }
            }
        }

        return true;
    }
}
