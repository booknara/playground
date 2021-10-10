package com.booknara.problem.dfs;

import java.util.*;

/**
 * 261. Graph Valid Tree (Medium)
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
  // T:O(V+E), S:O(V+E)
  public boolean validTree(int n, int[][] edges) {
    // check input, n >= 1, edges >= 0
    if (n - 1 != edges.length) {
      // Tree must have n - 1 edges given conditions(no cycle, no multiple same edge)
      return false;
    }
    // build graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge: edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    // Child - Parent pair
    Map<Integer, Integer> parents = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    parents.put(0, -1);

    while (!stack.isEmpty()) {
      int node = stack.pop();
      List<Integer> neighbors = graph.get(node);
      for (int nei: neighbors) {
        if (parents.get(node) == nei) {
          // already established relation which is node(child) - nei(parent)
          continue;
        }

        if (parents.containsKey(nei)) {
          // already parent existed (rule violation)
          return false;
        }

        parents.put(nei, node);
        stack.push(nei);
      }
    }

    return parents.size() == n;
  }
}
