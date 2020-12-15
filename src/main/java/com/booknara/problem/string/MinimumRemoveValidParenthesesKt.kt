package com.booknara.problem.string

/**
 * 1249. Minimum Remove to Make Valid Parentheses (Medium)
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
class MinimumRemoveValidParenthesesKt {
  // T:O(n), S:O(1)
  fun minRemoveToMakeValid(s: String): String {
    if (s.isEmpty()) return s

    val res = StringBuilder()
    var count = 0
    for (c in s) {
      if (c == '(') {
        count++
        res.append(c)
      } else if (c == ')') {
        if (count > 0) {
          count--
          res.append(c)
        }
      } else {
        res.append(c)
      }
    }

    for (i in 0 until count) {
      res.deleteCharAt(res.lastIndexOf("("))
    }

    return res.toString()
  }
}