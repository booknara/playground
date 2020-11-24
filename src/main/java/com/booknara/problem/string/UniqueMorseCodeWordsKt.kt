package com.booknara.problem.string

/**
 * 804. Unique Morse Code Words (Easy)
 * https://leetcode.com/problems/unique-morse-code-words/
 */
class UniqueMorseCodeWordsKt {
  // T:O(N, the number of characters), S:O(N, the number of characters)
  fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morseTable = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")

    val res = mutableSetOf<String>()
    for (s in words) {
      val builder = StringBuilder()
      for (c in s) {
        //println(c)
        builder.append(morseTable[c - 'a'])
      }
      res.add(builder.toString())
    }

    return res.size
  }
}
