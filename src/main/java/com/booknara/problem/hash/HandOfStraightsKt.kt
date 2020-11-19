package com.booknara.problem.hash

/**
 * 846. Hand of Straights (Medium)
 * https://leetcode.com/problems/hand-of-straights/
 */
class HandOfStraightsKt {
  // T:O(n*logn), S:O(n)
  fun isNStraightHand(hand: IntArray, W: Int): Boolean {
    if (W == 1) return true
    if (hand.size % W != 0) return false

    val map = sortedMapOf<Int, Int>()
    for (i in hand.indices) {
      val v = hand[i]
      map[v] = map.getOrDefault(v, 0) + 1
    }

    //println(map)

    for ((k, v) in map) {
      // find one group (size of W)

      while (map[k] != 0) {
        //println("smallest: $smallest")
        val c1 = map[k] ?: 1
        map[k] = c1 - 1
        for (i in 1 until W) {
          val next = k + i
          if (!map.containsKey(next) || map.get(next) == 0) return false

          //println("next: $next")
          val c2 = map[next] ?: 1
          map[next] = c2 - 1
        }

        //println(map)
      }
    }

    return true
  }
}