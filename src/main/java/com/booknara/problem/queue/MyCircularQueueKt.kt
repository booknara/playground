package com.booknara.problem.queue

import java.util.*

/**
 * 622. Design Circular Queue (Medium)
 * https://leetcode.com/problems/design-circular-queue/
 */
class MyCircularQueue(k: Int) {
  private val size: Int
  private val deque: Deque<Int>
  init {
    size = k
    deque = ArrayDeque()
  }

  fun enQueue(value: Int): Boolean {
    // addLast()
    if (isFull()) {
      return false
    }

    deque.addLast(value)
    return true
  }

  fun deQueue(): Boolean {
    // pollFirst()
    if (isEmpty()) {
      return false
    }
    deque.pollFirst()
    return true
  }

  fun Front(): Int {
    // peekFirst()
    return if (isEmpty()) -1 else deque.peekFirst()
  }

  fun Rear(): Int {
    // peekLast()
    return if (isEmpty()) -1 else deque.peekLast()
  }

  fun isEmpty(): Boolean {
    // size = 0
    return deque.size == 0
  }

  fun isFull(): Boolean {
    // size == k
    return size == deque.size
  }
}