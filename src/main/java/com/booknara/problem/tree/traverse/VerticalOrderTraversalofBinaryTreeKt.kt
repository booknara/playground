package com.booknara.problem.tree.traverse

import java.util.*
import kotlin.collections.ArrayList

/**
 * 987. Vertical Order Traversal of a Binary Tree (Medium)
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class VerticalOrderTraversalofBinaryTreeKt {
  // T:O(n*logn), S:O(n)
  fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    // input check, the number of nodes >= 1
    // BFS
    val res = mutableListOf<ArrayList<Int>>()
    if (root == null) return res

    val map = mutableMapOf<Int, ArrayList<Int>>()
    val queue = LinkedList<Pair<Int,TreeNode?>>()
    queue.offer(Pair(0, root))

    var min = 0
    while (!queue.isEmpty()) {
      val temp = mutableMapOf<Int, PriorityQueue<Int>>()
      val size = queue.size
      for (i in 0 until size) {
        val n = queue.poll()

        min = Math.min(min, n.first)
        val list = temp.getOrDefault(n.first, PriorityQueue<Int>())

        list.offer(n.second?.`val`)
        temp.put(n.first, list)

        if (n.second?.left != null) {
          queue.offer(Pair(n.first - 1, n.second?.left))
        }

        if (n.second?.right != null) {
          queue.offer(Pair(n.first + 1, n.second?.right))
        }
      }

      temp.forEach { (k, v) ->
        val list = map.getOrDefault(k, ArrayList())
        while (!v.isEmpty()) {
          list.add(v.poll())
        }
        map.put(k, list)
      }
    }

    while (true) {
      if (map[min] == null) {
        break;
      }

      val list = ArrayList<Int>()
      map[min]?.forEach {
        list.add(it)
      }

      res.add(list)
      min++
    }

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}