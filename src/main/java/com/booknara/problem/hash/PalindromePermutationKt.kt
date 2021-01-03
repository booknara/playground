package com.booknara.problem.hash

/**
 * 266. Palindrome Permutation (Easy)
 * https://leetcode.com/problems/palindrome-permutation/
 */
class PalindromePermutationKt {
  // T:O(n), S:O(1)
  fun canPermutePalindrome(s: String): Boolean {
    if (s.isEmpty()) return true

    val bucket = IntArray(128) { 0 }
    var oddFound = false
    for (i in s.indices) {
      bucket[s[i].toInt()]++
    }

    for (i in 0 until 128) {
      if (bucket[i] % 2 == 1) {
        if (oddFound) return false
        oddFound = true
      }
    }

    return true
  }
}