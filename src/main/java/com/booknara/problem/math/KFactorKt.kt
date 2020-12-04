package com.booknara.problem.math

/**
 * 1492. The kth Factor of n (Medium)
 * https://leetcode.com/problems/the-kth-factor-of-n/
 */
class KFactorKt {
  // T:O(sqrt(n), S:O(1)
  fun kthFactor(n: Int, k: Int): Int {
    var count = k

    var i = 1
    while (i * i < n) {
      if (n % i == 0) {
        count--
        if (count == 0) return i
      }

      i++
    }

    i = Math.sqrt(n.toDouble()).toInt()
    while (i >= 1) {
      if (n % i == 0) {
        count--
        if (count == 0) return n / i
      }

      i--
    }
    return -1
  }

  // T:O(n), S:O(1)
  fun kthFactor1(n: Int, k: Int): Int {
    var count = k
    for (i in 1..n) {
      if (n % i == 0) {
        count--
        if (count == 0) return i
      }
    }

    return -1
  }
}