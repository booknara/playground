package com.booknara.problem.tree.bst

/**
 * 501. Find Mode in Binary Search Tree (Easy)
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
class FindModeInBinarySearchTreeKt {
  var res = mutableSetOf<Int>()
  var currValue = 0
  var currCount = 0
  var maxCount = 0

  // T:O(n), S:O(1, except the result)
  fun findMode(root: TreeNode?): IntArray {
    // input check
    if (root == null) return intArrayOf()

    inorder(root)

    return res.toIntArray()
  }

  fun inorder(node: TreeNode?) {
    // base case
    if (node == null) return

    inorder(node.left)
    if (currValue != node.`val`) {
      currCount = 0
    }
    currCount++

    if (currCount > maxCount) {
      res.clear()
      res.add(node.`val`)
      maxCount = currCount
    } else if (currCount == maxCount) {
      res.add(node.`val`)
    }
    currValue = node.`val`

    inorder(node.right)
  }

  // T:O(n), S:O(n)
  fun findMode1(root: TreeNode?): IntArray {
    // input check
    if (root == null) return intArrayOf()

    // key: number, value: count
    val map = mutableMapOf<Int, Int>()
    helper(root, map)

    val maxValue = map.values.max()
    val res = map.filterValues { it == maxValue }
        .keys
        .toIntArray()

    return res
  }

  fun helper(node: TreeNode?, map: MutableMap<Int, Int>) {
    // base case
    if (node == null) return

    map[node.`val`] = map.getOrDefault(node.`val`, 0) + 1
    helper(node.left, map)
    helper(node.right, map)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}