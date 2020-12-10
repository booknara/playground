package com.booknara.problem.tree.bst

/**
 * 109. Convert Sorted List to Binary Search Tree (Medium)
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
class ConvertSortedListToBinarySearchTreeKt {
  // T:O(n*logn), S:O(logn)
  fun sortedListToBST(head: ListNode?): TreeNode? {
    // input check, head can be null
    if (head == null) return null
    if (head.next == null) return TreeNode(head.`val`)

    var slow = head
    var fast = head
    var prev: ListNode? = null

    while (fast != null && fast.next != null) {
      prev = slow
      slow = slow!!.next
      fast = fast.next!!.next
    }

    prev!!.next = null

    val root = TreeNode(slow!!.`val`)
    root.left = sortedListToBST(head)
    root.right = sortedListToBST(slow.next)

    return root
  }

  class ListNode(var `val`: Int) {
    var next: ListNode? = null
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}