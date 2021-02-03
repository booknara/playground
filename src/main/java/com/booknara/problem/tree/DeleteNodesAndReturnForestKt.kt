package com.booknara.problem.tree

/**
 * 1110. Delete Nodes And Return Forest (Medium)
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
class DeleteNodesAndReturnForestKt {
  // T:O(n), S:O(h), recursive
  fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
    // input check
    val res = ArrayList<TreeNode?>()
    if (root == null) return res

    val set = mutableSetOf<Int>()
    for (i in to_delete) {
      set.add(i)
    }

    // root node handling
    if (!set.contains(root.`val`)) {
      res.add(root)
    }

    dfs(root, set, res)

    return res
  }

  fun dfs(node: TreeNode?, set: Set<Int>, res: ArrayList<TreeNode?>): TreeNode? {
    // base case
    if (node == null) return null

    var cur = node
    // post order
    cur.left = dfs(cur.left, set, res)
    cur.right = dfs(cur.right, set, res)

    if (set.contains(cur.`val`)) {
      if (cur.left != null) {
        res.add(cur.left)
      }
      if (cur.right != null) {
        res.add(cur.right)
      }
      cur = null
    }

    return cur
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}
