package com.booknara.problem.search.binary

/**
 * 378. Kth Smallest Element in a Sorted Matrix (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class KthSmallestElementInSortedMatrixKt {
  // T:O((m + n) * log(max value - min value), S:O(1)
  fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    // input check, k is always valid
    val row = matrix.size
    val col = matrix[0].size

    var s = matrix[0][0]
    var e = matrix[row - 1][col - 1]
    while (s < e) {
      val mid = s + (e - s) / 2

      val midIndex = find(matrix, mid)
      //println("$mid, $midIndex")

      if (midIndex < k) {
        s = mid + 1
      } else {
        e = mid
      }
    }

    return e
  }

  fun find(matrix: Array<IntArray>, mid: Int): Int {
    var res = 0
    var r = 0
    var c = matrix[0].size - 1

    while (r < matrix.size && c >= 0) {
      if (matrix[r][c] <= mid) {
        res += c + 1
        r++
      } else {
        c--
      }
    }

    return res
  }
}