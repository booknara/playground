package com.booknara.problem.stack

import com.booknara.problem.iterator.NestedInteger
import java.util.*

/**
 * 364. Nested List Weight Sum II (Medium)
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
class NestedListWeightSumIIKt {
  // T:O(n), T:O(n)
  fun depthSumInverse(nestedList: List<NestedInteger>): Int {
    // input check
    var res = 0
    if (nestedList.isEmpty()) {
      return res
    }

    val queue = LinkedList<NestedInteger>()
    nestedList.forEach {
      queue.offer(it)
    }

    var sum = 0
    while (!queue.isEmpty()) {
      val size = queue.size

      for (i in 0 until size) {
        val cur = queue.poll()

        if (cur.isInteger()) {
          sum += cur.getInteger()
        } else {
          cur.getList()?.let {
            for (j in it.indices) {
              queue.offer(it[j])
            }
          }
        }
      }

      // previous sum + new sum from for loop
      res += sum
    }

    return res
  }
}