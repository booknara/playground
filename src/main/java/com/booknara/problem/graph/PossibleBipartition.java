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
    Map<Integer, Integer> color = new HashMap<>();
    public boolean possibleBipartition1(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= N + 1; ++i) graph.add(new ArrayList());

        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int node = 1; node <= N; ++node) {
            if (!color.containsKey(node) && !dfs(node, 0, graph)) return false;
        }

        return true;
    }

    private boolean dfs(int node, int color, List<List<Integer>> graph) {
        if (this.color.containsKey(node)) return this.color.get(node) == color;

        this.color.put(node, color);

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, color ^ 1, graph)) return false;
        }

        return true;
    }
}
