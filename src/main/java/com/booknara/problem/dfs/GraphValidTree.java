package com.booknara.problem.dfs;

import java.util.*;

/**
 * 261. Graph Valid Tree (Medium)
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
  // T:O(V+E), S:O(V+E)
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;

    List<List<Integer>> graph = new ArrayList<>();
    // V
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    // build adjacent graph
    // E
    for (int[] edge: edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]); // why?
    }

    // DFS
    Stack<Integer> stack = new Stack();
    Set<Integer> visited = new HashSet<>();
    stack.push(0);
    visited.add(0);

    while (!stack.isEmpty()) {
      int node = stack.pop();
      List<Integer> list = graph.get(node);    // 1, 2, 3
      for (int nei: list) {
        if (visited.contains(nei)) {
          continue;
        }

        visited.add(nei);
        stack.push(nei);
      }
    }

    return visited.size() == n;
  }
}
