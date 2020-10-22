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
        // input check, graph.length >= 1
        int n = graph.length;

        // 1:red, 2:blue, 0:undetermined
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                // 0:undetermined
                if (!bfs(graph, colors, i)) return false;
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int[] colors, int n) {
        Queue<Element> q = new LinkedList<>();
        colors[n] = 1;
        q.offer(new Element(n, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Element e = q.poll();
                // color = e.color
                // check connected edge
                for (int nei: graph[e.index]) {
                    // 0, same, different
                    if (colors[nei] == e.color) {
                        return false;
                    }

                    if (colors[nei] == 0) {
                        colors[nei] = e.color == 1 ? 2 : 1;
                        q.offer(new Element(nei, colors[nei]));
                    }
                }
            }
        }

        return true;
    }

    static class Element {
        int index;
        int color;
        Element (int index, int color) {
            this.index = index;
            this.color = color;
        }
    }
}
/**
 Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 Generate adjacent relation


 0:[1,3]
 1:[0,2]
 2:[1,3]
 3:[0,2]

 int[] color = new int[graph.length];    // 1:red, 2:blue, 0:undetermined
 [0,1,2,3]
 [1,2,1,2]

 Queue<Integer> q = new LinkedList<>();
 // 0 -> 1,3 -> 2
 Output: true
 */