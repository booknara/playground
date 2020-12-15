package com.booknara.problem.union

/**
 * 323. Number of Connected Components in an Undirected Graph (Medium)
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
class NumberOfConnectedComponentsInUndirectedGraphKt {
  // T:O(n with path compression), S:O(n)
  fun countComponents(n: Int, edges: Array<IntArray>): Int {
    // input check
    if (n < 2) return n

    val root = IntArray(n) { i -> i }

    var res = n
    for (i in edges.indices) {
      val edge = edges[i]
      // find
      val root1 = findRoot(root, edge[0])
      val root2 = findRoot(root, edge[1])
      if (root1 != root2) {
        // union
        root[root2] = root1
        res--
      }
    }

    return res
  }

  // find
  fun findRoot(root: IntArray, idx: Int): Int {
    var rootIdx = idx
    while (root[rootIdx] != rootIdx) {
      root[rootIdx] = root[root[rootIdx]] // path compression (advanced)
      rootIdx = root[rootIdx]
    }

    return rootIdx
  }
}