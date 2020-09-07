package com.booknara.problem.graph;

import java.util.*;

/**
 * 886. Possible Bipartition (Medium)
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {
    // Union-find
    // TODO: need to understand
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            colors[i] = i;
        }

        for(int i = 0; i < dislikes.length; ++i) {
            int p1 = dislikes[i][0], p2 = dislikes[i][1];
            if (colors[p2] == p2) {
                colors[p2] = p1;
            } else {
                int[] uf1 = find(p1, colors), uf2 = find(p2, colors);
                if(uf1[0] == uf2[0] && uf1[1] == uf2[1]) return false;
            }
        }
        return true;
    }

    private int[] find(int p, int[] colors) {
        int color = 0;
        while(colors[p] != p) {
            p = colors[p];
            color = color == 0 ? 1 : 0;
        }
        return new int[] {p, color};
    }

    // Bipartite (dfs)
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

    // Bipartite (bfs)
    // T:O(v+e), S:O(v+e)
    public boolean possibleBipartition2(int N, int[][] dislikes) {
        // input check
        if (N == 1) return true;
        if (dislikes == null || dislikes.length == 0) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        // adjacent graph
        generateGraph(dislikes, map);

        int[] colors = new int[N];
        // [0,0,0,0], dislikes = [[1,2],[1,3],[2,4]]
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && map.containsKey(i + 1)) {
                if (!isBipartition(colors, i, map)) return false;
            }
        }

        return true;
    }
    // 0
    public boolean isBipartition(int[] colors, int index, Map<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        colors[index] = 1;
        // [1,0,0,0] q: [0]
        while (!q.isEmpty()) {
            int i = q.poll();
            int color = colors[i];  // 1(0), 2(1)
            // [1:[2,3]]
            if (!map.containsKey(i + 1)) continue;

            for (int nei: map.get(i + 1)) {
                if (colors[nei - 1] == color) return false;

                // // [1,2,2,1] q: [1,2]
                if (colors[nei - 1] == 0) {
                    colors[nei - 1] = color == 1 ? 2 : 1;
                    q.offer(nei - 1);
                }
            }
        }

        return true;
    }

    public void generateGraph(int[][] dislikes, Map<Integer, List<Integer>> map) {
        for (int [] d: dislikes) {
            List<Integer> list1 = map.getOrDefault(d[0], new ArrayList<>());
            list1.add(d[1]);
            map.put(d[0], list1);

            List<Integer> list2 = map.getOrDefault(d[1], new ArrayList<>());
            list2.add(d[0]);
            map.put(d[1], list2);
        }
    }
}

/**
 Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 Output: true
 Explanation: group1 [1,4], group2 [2,3]

 [0,0,0,0], dislikes = [[1,2],[1,3],[2,4]]
 [
 1:[2,3],
 2:[4]
 ]
 */
