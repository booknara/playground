package com.booknara.problem.dfs

import com.booknara.problem.iterator.NestedInteger

/**
 * 339. Nested List Weight Sum (Easy)
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
class NestedListWeightSumKt {
  var sum = 0
  // T:O(n), T:O(n), n: The total number of nested elements
  fun depthSum(nestedList: List<NestedInteger>): Int {
    dfs(nestedList, 1)

    return sum
  }

  fun dfs(nestedList: List<NestedInteger>, depth: Int) {
    nestedList.forEach {
      if (it.isInteger()) {
        sum += it.getInteger() * depth
      } else {
        dfs(it.getList(), depth + 1)
      }
    }
  }
}