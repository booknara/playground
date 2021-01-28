package com.booknara.problem.stack

/**
 * 84. Largest Rectangle in Histogram (Hard)
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
class LargestRectangleHistogramKt {

  var totalMax = 0
  // TLE error because of T:O(nlogn), S:O(logn)
  fun largestRectangleArea1(heights: IntArray): Int {
    // input check, heights.length >= 1

    divide(heights, 0, heights.size - 1)

    return totalMax
  }

  fun divide(heights: IntArray, start: Int, end: Int) {
    // base case
    if (start == end) {
      totalMax = Math.max(totalMax, heights[start])
      return
    }

    val index = findMin(heights, start, end)
    totalMax = Math.max(totalMax, heights[index] * (end - start + 1))

    if (start != index) {
      // left
      divide(heights, start, index - 1)
    }
    if (end != index) {
      // right
      divide(heights, index + 1, end)
    }
  }

  fun findMin(heights: IntArray, start: Int, end: Int): Int {
    var min = Int.MAX_VALUE // height value is less than 10^4
    var index = -1
    for (i in start until end + 1) {
      if (heights[i] < min) {
        min = heights[i]
        index = i
      }
    }

    return index
  }

  // TLE error because of T:O(n^2), S:O(1)
  fun largestRectangleArea2(heights: IntArray): Int {
    // input check, heights.length >= 1
    var max = 0

    for (i in heights.indices) {
      var minHeight = heights[i]
      for (j in i until heights.size) {
        minHeight = Math.min(minHeight, heights[j])
        max = Math.max(max, (j - i + 1) * minHeight)
      }
    }

    return max
  }
}