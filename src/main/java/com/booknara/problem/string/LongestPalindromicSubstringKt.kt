package com.booknara.problem.string

/**
 * 5. Longest Palindromic Substring (Medium)
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
class LongestPalindromicSubstringKt {
  // T:O(n^2), S:O(1)
  fun longestPalindrome(s: String): String {
    // input check, s.length >= 1
    if (s.length == 1) return s

    var res: String = ""
    var max = 0

    // "cbbd"
    for (i in s.indices) {
      // odd (e.g. aba)
      var l = i - 1
      var r = i + 1
      while (l >= 0 && r < s.length) {
        if (s[l] != s[r]) break
        l--
        r++
      }

      // l ~ r : Palindrome
      if (max < r - l - 1) {
        max = r - l - 1
        res = s.substring(l + 1, r) // inclusive ~ exclusive
      }

      // even (e.g. aabbaa)
      l = i - 1
      r = i
      while (l >= 0 && r < s.length) {
        if (s[l] != s[r]) break
        l--
        r++
      }

      // l ~ r : Palindrome
      if (max < r - l - 1) {
        max = r - l - 1
        res = s.substring(l + 1, r) // inclusive ~ exclusive
      }
    }

    return res
  }
}