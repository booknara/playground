package com.booknara.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite? (Medium)
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class GraphBipartite {
    // T:O(v + e), S:O(v)
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }

        // 0: not visited, 1: red, 2: blue
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                if (!isBipartite(graph, colors, i)) return false;
            }
        }

        return true;
    }

    private boolean isBipartite(int[][] graph, int[] colors, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        colors[source] = 1;  // 1: blue, 2: red
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int next = colors[v] == 1 ? 2 : 1;
            for (int n: graph[v]) {
                if (colors[n] == 0) {
                    // color is not decided
                    colors[n] = next;
                    queue.offer(n);
                } else if (colors[n] != next) {
                    // not bipartite graph because neighbor node has same color
                    return false;
                }
            }
        }

        return true;
    }
}
