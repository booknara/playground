package com.booknara.problem.twopointers

/**
 * 763. Partition Labels (Medium)
 * https://leetcode.com/problems/partition-labels/
 */
class PartitionLabelsKt {
  // T:O(n), S:O(1)
  fun partitionLabels(S: String): List<Int> {
    // input check, s.length >= 1
    val res = ArrayList<Int>()

    val lastIndex = IntArray(26) { 0 }
    for (i in S.indices) {
      //println(c)
      val c = S[i]
      lastIndex[c - 'a'] = i
    }

    var start = 0
    var end = 0
    for (i in S.indices) {
      end = Math.max(end, lastIndex[S[i] - 'a'])
      if (end == i) {
        res.add(end - start + 1)
        start = end + 1
      }
    }


    return res
  }
}