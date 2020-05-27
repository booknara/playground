package com.booknara.problem.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 886. Possible Bipartition (Medium)
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {
    // Union-find
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] another = new int[N+1];
        for (int i = 0; i <= N; i++) {
            another[i] = i; // initial
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (another[a] == a && another[b] == b) {
                another[a] = b;
                another[b] = a;
            } else if (another[a] == a && another[b] != b) {
                another[a] = another[another[b]];
            } else if (another[b] ==b && another[a] != a) {
                another[b] = another[another[a]];
            } else if (another[b] == another[a]) {
                return false;
            }
        }

        return true;
    }

    // Bipartite
    // T:O(v+e), S:O(v+e)
    public boolean possibleBipartition1(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
            List<Integer> list1 = graph.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            graph.put(edge[0], list1);

            List<Integer> list2 = graph.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            graph.put(edge[1], list2);
        }

        Map<Integer, Integer> colors = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!colors.containsKey(i) && !dfs(i, 0, colors, graph)) return false;
        }

        return true;
    }

    private boolean dfs(int node, int color,
                        Map<Integer, Integer> colors,
                        Map<Integer, List<Integer>> graph) {
        if (colors.containsKey(node)) return colors.get(node) == color;

        colors.put(node, color);
        if (!graph.containsKey(node)) return true;

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, color ^ 1, colors, graph)) return false;
        }

        return true;
    }
}
