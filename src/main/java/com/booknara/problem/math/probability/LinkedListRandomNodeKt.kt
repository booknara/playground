package com.booknara.problem.math.probability

import java.util.*

/**
 * 382. Linked List Random Node (Medium)
 * https://leetcode.com/problems/linked-list-random-node/
 */
class LinkedListRandomNodeKt(head: ListNode?) {
  private val head = head

  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */

  // T:O(n), S:O(1)
  /** Returns a random node's value. */
  fun getRandom(): Int {
    var result = 0
    var cur = this.head
    var size = 1

    while (cur != null) {
      val random = Random().nextInt(size) + 1  // 1 ~ size
      if (random == size) {
        result = cur.`val`
      }

      cur = cur.next
      size++
    }

    return result
  }

  fun getRandom1(): Int {
    var size = 0
    var cur = this.head
    while (cur != null) {
      cur = cur.next
      size++
    }

    var random = Random().nextInt(size)  // 0 ~ size - 1
    cur = this.head
    while (random != 0) {
      cur = cur!!.next
      random--
    }

    return cur!!.`val`
  }

// T:O(n), S:O(n)
//  val list = ArrayList<Int>()
//  init {
//    var cur = head
//    while (cur != null) {
//      list.add(cur.`val`)
//      cur = cur.next
//    }
//  }
//
//  fun getRandom(): Int {
//    val random = Random().nextInt(list.size)  // 0 ~ size - 1
//
//    return list[random]
//  }
//
  class ListNode(var `val`: Int) {
    var next: ListNode? = null
  }
}