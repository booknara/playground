package com.booknara.problem.union

/**
 * 1101. The Earliest Moment When Everyone Become Friends (Medium)
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 */
class EarliestMomentWhenEveryoneBecomeFriendsKt {
  // T:O(nlogn), S:O(n)
  fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
    val root = IntArray(n) { i -> i }
    val rank = IntArray(n) { 1 }

    var groups = n
    // timestamp should be sorted
    logs.sortBy { i -> i[0] }
    for (i in logs.indices) {
      val time = logs[i][0]
      val root1 = find(root, logs[i][1])
      val root2 = find(root, logs[i][2])
      if (root1 != root2) {
        if (rank[root1] < rank[root2]) {
          root[root1] = root2
        } else if (rank[root1] > rank[root2]) {
          root[root2] = root1
        } else {
          root[root2] = root1
          rank[root2]++
        }

        groups--
        if (groups == 1) {
          return time
        }
      }
    }

    return -1
  }

  fun find(root: IntArray, index: Int): Int {
    if (index == root[index]) {
      return index
    }

    root[index] = find(root, root[index])
    return root[index]
  }
}
