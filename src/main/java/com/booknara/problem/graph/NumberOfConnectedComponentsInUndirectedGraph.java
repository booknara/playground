package com.booknara.problem.graph;

/**
 * 323. Number of Connected Components in an Undirected Graph (Medium)
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
    // T:O(n), S:O(n)
    public int countComponents(int n, int[][] edges) {
        // input check
        if (edges == null || edges.length == 0) return n;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        int res = n;
        for (int[] e: edges) {
            int root1 = findRoot(roots, e[0]);
            int root2 = findRoot(roots, e[1]);
            // union
            if (root1 != root2) {
                roots[root1] = root2;
                res--;
            }
        }

        return res;
    }

    // T:O(1) because of path compression, S:O(1)
    public int findRoot(int[] roots, int id) {
        // find
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];   // path compression
            id = roots[id];
        }

        return id;
    }
}
