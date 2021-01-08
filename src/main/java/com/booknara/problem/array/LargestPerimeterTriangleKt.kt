package com.booknara.problem.array

/**
 * 976. Largest Perimeter Triangle (Easy)
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
class LargestPerimeterTriangleKt {
  // T:O(nlogn), S:O(1)
  fun largestPerimeter(A: IntArray): Int {
    // input check
    if (A.size <= 2) return 0

    A.sortDescending()
    for (i in 0 until A.size - 2) {
      if (A[i] < A[i + 1] + A[i + 2]) {
        return A[i] + A[i + 1] + A[i + 2]
      }
    }

    return 0
  }
}