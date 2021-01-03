package com.booknara.problem.bfs

import java.util.*

/**
 * 127. Word Ladder (Medium)
 * https://leetcode.com/problems/word-ladder/
 */
class WordLadderKt {
  // O(n*m), n : the number of words, m : the length of word
  fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    // BFS
    val q = LinkedList<String>()
    var count = 1
    val wordSet = mutableSetOf<String>()
    for (s in wordList) {
      wordSet.add(s)
    }

    q.offer(beginWord)
    wordSet.remove(beginWord)

    while (!q.isEmpty()) {
      val size = q.size
      for (i in 0 until size) {
        val s = q.poll()
        if (s == endWord) return count

        for (i in s.indices) {
          val nei = StringBuilder(s)
          for (j in 0..25) {
            val d = 'a'.toInt() + j
            val c = d.toChar()
            nei.setCharAt(i, c);

            if (!wordSet.contains(nei.toString())) continue

            wordSet.remove(nei.toString())
            q.offer(nei.toString())
          }
        }
      }

      count++
    }

    return 0
  }
}