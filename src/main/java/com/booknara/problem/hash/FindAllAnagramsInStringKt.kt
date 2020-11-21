package com.booknara.problem.hash

/**
 * 438. Find All Anagrams in a String (Medium)
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
class FindAllAnagramsInStringKt {
  // T:O(n), S:O(1)
  fun findAnagrams(s: String, p: String): List<Int> {
    // input check, s can be empty string, p is not empty string
    val res = mutableListOf<Int>()
    if (s.isEmpty()) return res

    val bucket = IntArray(26) // only lowercase
    for (c in p) {
      bucket[c.toInt() - 'a'.toInt()]++
    }

    var l = 0
    var r = 0
    val size = p.length
    val slice = IntArray(26)
    while (r < s.length) {
      val c = s[r]
      slice[c.toInt() - 'a'.toInt()]++
      if (r - l + 1 == size) {
        // compare bucket and slice
        if (bucket.contentEquals(slice)) {
          res.add(l)
        }

        val d = s[l]
        slice[d.toInt() - 'a'.toInt()]--
        l++
      }

      r++
    }

    return res
  }
}