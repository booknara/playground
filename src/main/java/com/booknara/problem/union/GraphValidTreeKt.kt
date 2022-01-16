package com.booknara.problem.union

/**
 * 261. Graph Valid Tree (Medium)
 * https://leetcode.com/problems/graph-valid-tree/
 */
class GraphValidTreeKt {
  // T:O(n), S:O(n)
  fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    var edge = n - 1
    val root = IntArray(n) {i -> i}
    val rank = IntArray(n) { 1 }

    for (i in edges.indices) {
      val root1 = find(root, edges[i][0])
      val root2 = find(root, edges[i][1])
      if (root1 == root2) {
        return false
      }

      // union
      if (rank[root1] < rank[root2]) {
        root[root1] = root2
      } else if (rank[root1] < rank[root2]) {
        root[root2] = root1
      } else {
        root[root2] = root1
        rank[root1]++
      }

      edge--
    }

    return edge == 0
  }

  // T:O(a, a means Inverse Ackermann function. In practice constant)
  fun find(root: IntArray, index: Int): Int {
    if (index == root[index]) {
      return index
    }

    root[index] = find(root, root[index])
    return root[index]
  }
}
