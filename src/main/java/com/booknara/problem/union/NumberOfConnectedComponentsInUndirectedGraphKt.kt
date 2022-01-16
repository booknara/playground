package com.booknara.problem.union

/**
 * 323. Number of Connected Components in an Undirected Graph (Medium)
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
class NumberOfConnectedComponentsInUndirectedGraphKt {
  // T:O(n with path compression), S:O(n)
  fun countComponents(n: Int, edges: Array<IntArray>): Int {
    var res = n
    val root = IntArray(n) { i -> i }
    val rank = IntArray(n) { 1 }

    for (i in edges.indices) {
      val root1 = find(root, edges[i][0])
      val root2 = find(root, edges[i][1])
      if (root1 != root2) {
        // union
        if (rank[root1] < rank[root2]) {
          root[root1] = root2
        } else if (rank[root1] > rank[root2]) {
          root[root2] = root1
        } else {
          root[root1] = root2
          rank[root2]++
        }

        res--
      }
    }

    return res
  }

  // find
  fun find(root: IntArray, index: Int): Int {
    if (index == root[index]) {
      return index
    }
    root[index] = find(root, root[index])
    return root[index]
  }
}
