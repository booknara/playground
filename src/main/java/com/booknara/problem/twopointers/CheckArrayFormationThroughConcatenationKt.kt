package com.booknara.problem.twopointers

/**
 * 1640. Check Array Formation Through Concatenation (Easy)
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
class CheckArrayFormationThroughConcatenationKt {
  // T:O(n, the length of arr because the element of pieces is distinct), S:O(m, the length of pieces)
  fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val map = mutableMapOf<Int, IntArray>()
    for (i in pieces.indices) {
      val list = pieces[i]
      map[list[0]] = list
    }

    var arrIdx = 0
    while (arrIdx < arr.size) {
      if (map[arr[arrIdx]] == null) {
        return false
      }

      var start = 0
      val piece = map[arr[arrIdx]]!!
      for (j in piece.indices) {
        if (arr[arrIdx + start] != piece[j]) {
          return false
        }

        start++
      }

      arrIdx += start
    }

    return true
  }

  // T:O(n, the length of arr because the element of pieces is distinct), S:O(m, the length of pieces)
  fun canFormArray1(arr: IntArray, pieces: Array<IntArray>): Boolean {
    var arrIdx = 0
    val visited = mutableSetOf<Int>()

    while (arrIdx < arr.size) {
      var found = false
      var start = 0
      for (i in pieces.indices) {
        if (visited.contains(i)) continue

        val piece = pieces[i]
        for (j in piece.indices) {
          if (arr[arrIdx + start] != piece[j]) {
            start = 0
            break
          }

          start++
        }

        if (start != 0) {
          visited.add(i)
          found = true
          break
        }
      }

      if (!found) return false

      arrIdx += start
    }

    return true
  }
}