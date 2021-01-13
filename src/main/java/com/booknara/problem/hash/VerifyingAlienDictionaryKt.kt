package com.booknara.problem.hash

/**
 * 953. Verifying an Alien Dictionary (Easy)
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
class VerifyingAlienDictionaryKt {
  // T:O(n*m), S:(1)
  fun isAlienSorted(words: Array<String>, order: String): Boolean {
    // input check
    val bucket = IntArray(26) { 0 }
    for (i in order.indices) {
      val c = order[i]
      bucket[c - 'a'] = i
    }

    for (i in words.indices) {
      if (i == 0) continue

      val prev = words[i - 1]
      val cur = words[i]

      var j = 0
      var diffFound = false
      while (j < prev.length && j < cur.length) {
        if (prev[j] != cur[j]) {
          // different
          if (bucket[prev[j] - 'a'] > bucket[cur[j] - 'a']) {
            return false
          }
          diffFound = true
          break
        }
        j++
      }

      if (!diffFound && j < prev.length) {
        return false
      }
    }

    return true
  }
}