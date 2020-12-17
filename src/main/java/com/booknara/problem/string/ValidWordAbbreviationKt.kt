package com.booknara.problem.string

/**
 * 408. Valid Word Abbreviation (Easy)
 * https://leetcode.com/problems/valid-word-abbreviation/
 */
class ValidWordAbbreviationKt {
  // T:O(n), S:O(1)
  fun validWordAbbreviation(word: String, abbr: String): Boolean {
    if (word.isEmpty() && abbr.isEmpty()) return true
    if (word.isEmpty() || abbr.isEmpty()) return false

    var num = 0
    var wordIdx = 0
    var i = 0
    while (i < abbr.length) {
      val c = abbr[i]

      if (c.isDigit()) {
        if (num == 0 && c == '0') return false

        num = num * 10 + (c - '0')
      } else {
        if (num != 0) {
          //println(num)
          wordIdx += num
          num = 0
        }

        if (wordIdx >= word.length || word[wordIdx] != abbr[i]) return false
        wordIdx++
      }

      i++
    }

    wordIdx += num
    return wordIdx == word.length && i == abbr.length
  }
}