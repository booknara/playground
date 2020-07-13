package com.booknara.problem.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 797. All Paths From Source to Target (Medium)
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    // T:O(2^n*n), S:O(n)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        // input check
        if (graph == null || graph.length == 0) return res;

        dfs(graph, 0, graph.length - 1, new HashSet<>(), new ArrayList<>(), res);

        return res;
    }

    public void dfs(int[][] graph,
                    int node,
                    int dest,
                    Set<Integer> visited,
                    List<Integer> path,
                    List<List<Integer>> res) {
        if (visited.contains(node)) return;

        visited.add(node);
        path.add(node);
        if (node == dest) {
            res.add(path);
            return;
        }

        for (int ad: graph[node]) {
            dfs(graph, ad, dest, new HashSet<>(visited), new ArrayList<>(path), res);
        }
    }
}
