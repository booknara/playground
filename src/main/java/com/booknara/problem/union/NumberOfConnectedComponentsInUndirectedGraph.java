package com.booknara.problem.union;

/**
 * 323. Number of Connected Components in an Undirected Graph (Medium)
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
  // T:O(n with path compression & union by rank), S:O(n)
  public int countComponents(int n, int[][] edges) {
    // input check
    if (edges == null || edges.length == 0) return n;

    // union-find setup
    int[] root = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
      rank[i] = 0;
    }

    int res = n;
    for (int[] edge : edges) {
      int r1 = find(root, edge[0]);
      int r2 = find(root, edge[1]);
      if (r1 == r2) {
        continue;
      }
      // union
      if (rank[r1] < rank[r2]) {
        root[r1] = r2;
        rank[r2] += rank[r1];
      } else {
        root[r2] = r1;
        rank[r1] += rank[r2];
      }
      res--;
    }

    return res;
  }

  // T:O(1) because of path compression, S:O(1)
  public int find(int[] roots, int id) {
    // find
    while (roots[id] != id) {
      roots[id] = roots[roots[id]];   // path compression
      id = roots[id];
    }

    return id;
  }
}
