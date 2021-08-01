package com.booknara.problem.tree

/**
 * 536. Construct Binary Tree from String (Medium)
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 */
class ConstructBinaryTreeFromStringKt {
  var index = 0

  // T:O(n), S:O(h)
  fun str2tree(s: String): TreeNode? {
    if (s.isEmpty()) return null

    var num = 0
    var sign = 1
    if (s[index] == '-') {
      sign *= -1
      index++
    }

    while (index < s.length && Character.isDigit(s[index])) {
      num = num * 10 + (s[index] - '0')
      index++
    }

    val res = TreeNode(num * sign)

    // left node
    if (index < s.length) {
      if (s[index] == '(') {
        index++
        res.left = str2tree(s)
      } else {
        index++
        return res
      }
    }

    // right node
    if (index < s.length) {
      if (s[index] == '(') {
        index++
        res.right = str2tree(s)
      } else {
        index++
        return res
      }
    }

    if (index < s.length && s[index] == ')') {
      index++
    }

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}
