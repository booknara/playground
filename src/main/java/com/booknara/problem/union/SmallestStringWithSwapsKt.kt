package com.booknara.problem.union

import java.util.*
import kotlin.collections.HashMap

/**
 * 1202. Smallest String With Swaps (Medium)
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
class SmallestStringWithSwapsKt {
  // T:O(n), S:O(n)
  fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
    val root = IntArray(s.length) {i -> i}
    val rank = IntArray(s.length) { 1 }

    for (i in pairs.indices) {
      val root1 = find(root, pairs[i][0])
      val root2 = find(root, pairs[i][1])
      if (root1 != root2) {
        when {
            rank[root1] < rank[root2] -> {
              root[root1] = root2
            }
            rank[root2] < rank[root1] -> {
              root[root2] = root1
            }
            else -> {
              root[root2] = root1
              rank[root1]++
            }
        }
      }
    }

    val map = HashMap<Int, PriorityQueue<Char>>()
    for (i in root.indices) {
      val r = find(root, i)
      if (!map.containsKey(r)) {
        map[r] = PriorityQueue()
      }

      map[r]?.offer(s[i])
    }

    val res = StringBuilder()
    for (i in root.indices) {
      val r = find(root, i)
      res.append(map[r]?.poll())
    }

    return res.toString()
  }

  fun find(root: IntArray, index: Int): Int {
    if (index == root[index]) {
      return index
    }

    root[index] = find(root, root[index])
    return root[index]
  }
}
