package com.booknara.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1245. Tree Diameter (Medium)
 * https://leetcode.com/problems/tree-diameter/
 */
public class TreeDiameter {
    // res[0]: node, res[1]: distance
    int[] res = new int[2];

    // T:O(n), S:O(h)
    public int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return 0;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // build generation
        for (int[] e: edges) {
            // e[0]
            graph.get(e[0]).add(e[1]);
            // e[1]
            graph.get(e[1]).add(e[0]);
        }

        // two phase to chck the longest path
        dfs(graph, -1, edges[0][0], 0);
        dfs(graph, -1, res[0], 0);

        return res[1];
    }

    public void dfs(List<List<Integer>> graph, int parent, int node, int len) {
        if (len > res[1]) {
            res = new int[] {node, len};
        }

        for (int i: graph.get(node)) {
            // for not going backward
            if (parent != i) {
                dfs(graph, node, i, len + 1);
            }
        }
    }
}
