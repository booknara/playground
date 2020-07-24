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

        dfs(graph, 0, graph.length - 1, new HashSet<>(), res);
        return res;
    }

    public void dfs(int[][] graph, int src, int dst, Set<Integer> visited, List<List<Integer>> res) {
        if (visited.contains(src)) return;

        visited.add(src);
        if (src == dst) {
            res.add(new ArrayList<>(visited));
            return;
        }

        for (int s: graph[src]) {
            dfs(graph, s, dst, new HashSet<>(visited), res);
        }
    }
}
