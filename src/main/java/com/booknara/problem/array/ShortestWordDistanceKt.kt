package com.booknara.problem.array

/**
 * 243. Shortest Word Distance (Easy)
 * https://leetcode.com/problems/shortest-word-distance/
 */
class ShortestWordDistanceKt {
  // T:O(n), S:O(1)
  fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
    // input check, word1,word2 are both in the list
    var index1: Int? = null
    var index2: Int? = null
    var distance = Int.MAX_VALUE
    for (i in words.indices) {
      var found = false
      if (words[i].equals(word1)) {
        index1 = i
      } else if (words[i].equals(word2)) {
        index2 = i
      }

      if (index1 != null && index2 != null) {
        distance = Math.min(distance, Math.abs(index2 - index1))
      }
    }

    return distance
  }
}