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
        // input check
        if (graph == null || graph.length == 0) return true;

        // O: undetermined, 1:red:, 2:blue
        // [0,0,0,0]
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!isBipartite(graph, colors, i)) return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph, int[] colors, int i) {
        Queue<Integer> q = new LinkedList<>();
        colors[i] = 1;
        q.offer(i);
        while (!q.isEmpty()) {
            int n = q.poll();
            int color = colors[n];
            for (int nei: graph[n]) {
                if (colors[nei] == color) return false; // the neighbor has the same color, valid

                if (colors[nei] == 0) {
                    // undetermined
                    colors[nei] = (color == 1) ? 2 : 1;
                    q.offer(nei);
                }
            }
        }

        return true;
    }
}
/**
 [0,0,0,0]
 Input: [
 0:[1,3]
 1:[0,2]
 2:[1,3]
 3:[0,2]
 ]
 */