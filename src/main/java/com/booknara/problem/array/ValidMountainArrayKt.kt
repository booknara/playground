package com.booknara.problem.array

/**
 * 941. Valid Mountain Array (Easy)
 * https://leetcode.com/problems/valid-mountain-array/
 */
class ValidMountainArrayKt {
  // T:O(n), S:O(1)
  fun validMountainArray(arr: IntArray): Boolean {
    if (arr.size < 3) return false

    var max = -1
    var maxIdx = -1
    // find the max index
    for (i in arr.indices) {
      if (arr[i] > max) {
        max = arr[i]
        maxIdx = i
      }
    }

    if (maxIdx == 0 || maxIdx == arr.size - 1) return false

    var l = maxIdx - 1
    var r = maxIdx + 1
    while (l >= 0 || r <= arr.size - 1) {
      if (l >= 0 && arr[l] >= arr[l + 1])  {
        return false
      }

      if (r <= arr.size - 1 && arr[r - 1] <= arr[r]) {
        return false
      }
      l--
      r++
    }

    return true
  }
}