package com.booknara.problem.greedy

/**
 * 605. Can Place Flowers (Easy)
 * https://leetcode.com/problems/can-place-flowers/
 */
class CanPlaceFlowersKt {
  // T:O(n), S:O(1)
  fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    // input check
    if (n == 0) return true

    var count = 0
    // single element
    if (flowerbed.size == 1) {
      if (flowerbed[0] == 0) {
        count++
      }

      return count == n
    }

    var i = 0
    while (i < flowerbed.size) {
      if (flowerbed[i] == 1) {
        i++
        continue
      }

      // println(i)
      if (i == 0) {
        // first element
        if (i + 1 < flowerbed.size && flowerbed[i + 1] == 0) {
          count++
          i++
        }
      } else if (i == flowerbed.size - 1) {
        // last element
        if (i - 1 >= 0 && flowerbed[i - 1] == 0) {
          count++
          i++
        }
      } else {
        // middle element
        if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
          count++
          i++
        }
      }

      // println("$i, $count")
      if (count == n) return true
      i++
    }

    return false
  }
}