package com.booknara.problem.array

/**
 * 1662. Check If Two String Arrays are Equivalent (Easy)
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
class CheckIfTwoStringArraysAreEquivalentKt {
  // T:O(max(len(n), len(m)), S:O(1)
  fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    // input check, word1 >= 1, word2 >= 1
    var strIdx1 = 0
    var strIdx2 = 0
    var charIdx1 = 0
    var charIdx2 = 0

    while (strIdx1 < word1.size && strIdx2 < word2.size) {

      // different
      if (word1[strIdx1][charIdx1] != word2[strIdx2][charIdx2]) return false

      // word1
      if (charIdx1 == word1[strIdx1].length - 1) {
        charIdx1 = 0
        strIdx1++
      } else {
        charIdx1++
      }

      // word2
      if (charIdx2 == word2[strIdx2].length - 1) {
        charIdx2 = 0
        strIdx2++
      } else {
        charIdx2++
      }
    }

    return strIdx1 == word1.size && strIdx2 == word2.size
  }

  // T:O(max(num(n), num(m))), S:O(max(len(n), len(m))
  fun arrayStringsAreEqual1(word1: Array<String>, word2: Array<String>): Boolean {
    // input check, word1 >= 1, word2 >= 1
    val builder1 = StringBuilder()
    for (i in 0 until word1.size) {
      builder1.append(word1[i])
    }
    val builder2 = StringBuilder()
    for (i in 0 until word2.size) {
      builder2.append(word2[i])
    }

    return builder1.toString() == builder2.toString()
  }
}