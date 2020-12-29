package com.booknara.problem.dc

/**
 * 240. Search a 2D Matrix II (Medium)
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
class Search2DMatrixIIKt {
  // T:O(n+m), S:O(1)
  fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size

    var i = 0
    var j = n - 1
    while (i < m && j >= 0) {
      if (matrix[i][j] == target) return true

      if (matrix[i][j] < target) {
        // column decrease
        i++
      } else {
        // row increase
        j--
      }
    }

    return false
  }
}