package com.booknara.problem.tree

import java.util.*

/**
 * 117. Populating Next Right Pointers in Each Node II (Medium)
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
class PopulatingNextRightPointersIIKt {
  var leftAtMost: Node? = null
  var prev: Node? = null

  // T:O(n), S:O(1)
  fun connect(root: Node?): Node? {
    if (root == null) return null

    leftAtMost = root
    var cur: Node? = null
    while (leftAtMost != null) {
      prev = null
      cur = leftAtMost
      leftAtMost = null

      while (cur != null) {
        connectChild(cur.left)
        connectChild(cur.right)
        cur = cur.next
      }
    }

    return root
  }

  fun connectChild(node: Node?) {
    if (node == null) return

    if (prev == null) {
      leftAtMost = node
    } else {
      prev?.next = node
    }

    prev = node
  }

  // T:O(n), S:O(n)
  fun connect1(root: Node?): Node? {
    if (root == null) return null

    val queue = LinkedList<Node>()
    queue.offer(root)

    while (!queue.isEmpty()) {
      val size = queue.size

      var prev: Node? = null
      for (i in 0 until size) {
        val cur = queue.poll()

        if (cur.left != null) {
          queue.offer(cur.left)
        }

        if (cur.right != null) {
          queue.offer(cur.right)
        }

        if (prev != null) {
          prev.next = cur
        }
        prev = cur
      }
    }

    return root
  }

  class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
    }
}