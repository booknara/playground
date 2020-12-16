package com.booknara.problem.list

/**
 * 369. Plus One Linked List (Medium)
 * https://leetcode.com/problems/plus-one-linked-list/
 */
class PlusOneLinkedListKt {
  // T:O(n), S:(1)
  fun plusOne(head: ListNode?): ListNode? {
    // input check, the number of head list >= 1
    var cur = head
    var prev: ListNode? = null
    while (cur != null) {
      if (cur.`val` != 9) {
        prev = cur
      }
      cur = cur.next
    }

    var res: ListNode? = null
    var temp: ListNode? = null
    if (prev != null) {
      prev.`val` = prev.`val` + 1
      res = head
      temp = prev.next
    } else {
      res = ListNode(1)
      res.next = head
      temp = head
    }

    while (temp != null) {
      temp.`val` = 0
      temp = temp.next
    }

    return res
  }

  class ListNode(var `val`: Int) {
    var next: ListNode? = null
  }
}