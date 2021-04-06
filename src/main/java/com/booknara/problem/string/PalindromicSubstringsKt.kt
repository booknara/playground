package com.booknara.problem.string

/**
 * 647. Palindromic Substrings (Medium)
 * https://leetcode.com/problems/palindromic-substrings/
 */
class PalindromicSubstringsKt {
  // T:O(n^2), S:O(1)
  fun countSubstrings(s: String): Int {
    var res = 0

    if (s.isEmpty()) return res

    for (i in s.indices) {
      res += findAllPalindrome(s, i, i) // odd
      res += findAllPalindrome(s, i, i + 1) // even
    }

    return res
  }

  fun findAllPalindrome(s: String, l: Int, r: Int): Int {
    var count = 0
    var left = l
    var right = r

    while (left >= 0 && right < s.length) {
      if (s[left] != s[right]) {
        break
      }

      //println(s.substring(left, right + 1))
      count++
      left--
      right++
    }

    return count
  }
}
