package com.booknara.problem.stack

import java.util.*

/**
 * 71. Simplify Path (Medium)
 * https://leetcode.com/problems/simplify-path/
 */
class SimplifyPathKt {
  // T:O(n), S:O(n)
  fun simplifyPath(path: String): String {
    val res = StringBuilder()

    // two slash to one slash
    // path.replace("//", "/")

    val tokens = path.split("/")

    val stack = Stack<String>()
    for (token in tokens) {
      if (token.isEmpty()) continue

      //println(token)
      if (token == ".") continue

      if (token == "..") {
        if (!stack.isEmpty()) stack.pop()
      } else {
        stack.push(token)
      }
    }

    while (!stack.isEmpty()) {
      res.insert(0, "/" + stack.pop())
    }

    return if (res.isEmpty()) "/" else res.toString()
  }
}