package com.booknara.problem.tree

import java.util.*

/**
 * 116. Populating Next Right Pointers in Each Node (Medium)
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
class PopulatingNextRightPointersKt {
    // T:O(n), S:O(n)
    fun connect(root: Node?): Node? {
        if (root == null) return root

        val queue = LinkedList<Node>()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val node = queue.poll()

                // there are two cases (perfect tree)
                node.left?.let {
                    // left -> right
                    it.next = node.right
                    queue.offer(it)
                }

                node.right?.let {
                    // right -> left
                    it.next = node.next?.left
                    queue.offer(it)
                }
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