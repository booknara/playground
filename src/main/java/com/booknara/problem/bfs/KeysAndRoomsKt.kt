package com.booknara.problem.bfs

import java.util.*

/**
 * 841. Keys and Rooms (Medium)
 * https://leetcode.com/problems/keys-and-rooms/
 */
class KeysAndRoomsKt {
  // T:O(v + e), S:O(v)
  fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    // input check, room.length >= 1
    val n = rooms.size
    val opened = BooleanArray(n) { false }

    val queue = LinkedList<Int>()
    queue.offer(0)

    while (!queue.isEmpty()) {
      val size = queue.size

      for (i in 0 until size) {
        val room = queue.poll()
        if (opened[room]) continue

        opened[room] = true

        val keys = rooms[room]  // [1,3]
        for (j in keys.indices) {
          if (opened[keys[j]]) continue

          queue.offer(keys[j])
        }
      }
    }

    // verify all rooms opened
    for (i in opened) {
      if (i == false) return false
    }
    return true
  }
}