package com.booknara.problem.string

/**
 * 1592. Rearrange Spaces Between Words (Easy)
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */
class RearrangeSpacesBetweenWordsKt {
  // T: O(n, the length of the input string), S: O(1)
  fun reorderSpaces(text: String): String {
    // input check
    if (text.isEmpty()) return text

    var wordCount = 0
    var totalSpace = 0
    var i = 0
    while (i < text.length) {
      if (text[i] != ' ') {
        wordCount++
        while (i < text.length && text[i] != ' ') i++
      } else {
        totalSpace++
        i++
      }
    }

    if (totalSpace == 0) {
      // e.g. "a"
      return text
    }

    val evenlySpace: Int
    val extraSpace: Int
    if (wordCount == 1) {
      // e.g. "  hello"
      evenlySpace = 0
      extraSpace = totalSpace
    } else {
      evenlySpace = totalSpace / (wordCount - 1)
      extraSpace = totalSpace % (wordCount - 1)
    }

    val spaceBuf = " ".repeat(evenlySpace)
    val res = StringBuilder()
    i = 0
    while (text[i] == ' ') {
      i++ // remove the leading whitespace
    }
    while (i < text.length) {
      if (text[i] != ' ') {
        res.append(text[i++])
      } else {
        while (i < text.length && text[i] == ' ') {
          i++
        }
        if (i < text.length) {
          res.append(spaceBuf)
        }
      }
    }

    if (extraSpace > 0) {
      // the extra spaces at the end
      res.append(" ".repeat(extraSpace))
    }

    return res.toString()
  }
}
