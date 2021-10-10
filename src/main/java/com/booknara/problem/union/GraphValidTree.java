package com.booknara.problem.union;

/**
 * 261. Graph Valid Tree (Medium)
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
  // T:O(n), S:O(n)
  public boolean validTree(int n, int[][] edges) {
    // check input
    if (edges.length != n - 1) {
      return false;
    }

    // union-find setup
    int[] root = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
      rank[i] = 0;
    }

    for (int[] edge: edges) {
      int r1 = find(root, edge[0]);
      int r2 = find(root, edge[1]);
      if (r1 == r2) {
        return false;
      }
      // union
      if (rank[r1] < rank[r2]) {
        root[r1] = r2;
        rank[r2] += rank[r1];
      } else {
        root[r2] = r1;
        rank[r1] += rank[r2];
      }
    }

    return true;
  }

  public int find(int[] root, int x) {
    while (x != root[x]) {
      x = root[x];
      root[x] = root[root[x]];  // path compression
    }

    return x;
  }
}
