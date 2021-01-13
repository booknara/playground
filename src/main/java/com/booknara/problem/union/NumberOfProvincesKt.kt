package com.booknara.problem.union

/**
 * 547. Number of Provinces (Medium)
 * https://leetcode.com/problems/number-of-provinces/
 */
class NumberOfProvincesKt {
  // T:O(n*n*logn), S:O(n)
  fun findCircleNum(isConnected: Array<IntArray>): Int {
    // input check
    val n = isConnected.size

    val roots = IntArray(n) { i -> i }
    val weights = IntArray(n) { 1 } // can be better using negative value of roots
    var count = isConnected.size
    for (i in isConnected.indices) {
      for (j in isConnected[i].indices) {
        if (i < j && isConnected[i][j] == 1) {
          val root1 = findRoot(roots, i)  // i -> root1
          val root2 = findRoot(roots, j)  // j -> root2
          if (root1 != root2) {
            // point smaller sized tree to root of larger, update size
            if (weights[root1] < weights[root2]) {
              roots[root1] = root2
              weights[j] += weights[i]
            } else {
              roots[root2] = root1
              weights[i] += weights[j]
            }

            count--
          }
        }
      }
    }

    return count
  }

  fun findRoot(roots: IntArray, idx: Int): Int {
    var index = idx
    while (roots[index] != index) {
      roots[index] = roots[roots[index]]  // path compression
      index = roots[index]
    }

    return index
  }
}