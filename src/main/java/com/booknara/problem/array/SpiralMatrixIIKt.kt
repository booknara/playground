package com.booknara.problem.array

/**
 * 59. Spiral Matrix II (Medium)
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
class SpiralMatrixIIKt {
  // T:O(n^2), S:(n^2)
  fun generateMatrix(n: Int): Array<IntArray> {
    // input check

    val dirs = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0)
    )

    val res = mutableListOf<IntArray>()
    for (i in 0 until n) {
      res.add(IntArray(n) { 0 })
    }

    var dir = 0
    val pair = intArrayOf(0, 0)
    var rowMin = -1
    var rowMax = n
    var colMin = -1
    var colMax = n
    for (i in 0 until n * n) {
      //println("${pair[0]} ${pair[1]} :${i + 1}")
      res[pair[0]][pair[1]] = i + 1

      pair[0] += dirs[dir][0]
      pair[1] += dirs[dir][1]

      //println(dir)
      if (pair[1] == colMax) {
        pair[0] += 1
        pair[1] -= 1
        dir = 1
        rowMin++
      } else if (pair[0] == rowMax) {
        pair[0] -= 1
        pair[1] -= 1
        dir = 2
        colMax--
      } else if (pair[1] == colMin) {
        pair[0] -= 1
        pair[1] += 1
        dir = 3
        rowMax--
      } else if (pair[0] == rowMin) {
        pair[0] += 1
        pair[1] += 1
        dir = 0
        colMin++
      }
    }

    return res.toTypedArray()
  }
}