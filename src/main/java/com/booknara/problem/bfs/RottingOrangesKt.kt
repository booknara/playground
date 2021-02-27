package com.booknara.problem.bfs

import java.util.*

/**
 * 994. Rotting Oranges (Medium)
 * https://leetcode.com/problems/rotting-oranges/
 */
class RottingOrangesKt {
  // T:O(n^2), S:O(n^2)
  fun orangesRotting(grid: Array<IntArray>): Int {
    // input check, m, n >= 1
    // finding rotten oranges
    var count = 0
    val queue = LinkedList<Pair<Int, Int>>()
    for (i in grid.indices) {
      val array = grid[i]
      for (j in array.indices) {
        if (array[j] == 1) {
          count++
        } else if (array[j] == 2) {
          queue.offer(Pair(i, j))
        }
      }
    }

    if (count == 0) return 0

    val dirs = arrayOf(
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(1, 0)
    )

    var min = -1
    while (!queue.isEmpty()) {
      val size = queue.size
      for (i in 0 until size) {
        val p = queue.poll()
        for (d in dirs) {
          val r = p.first + d[0]
          val c = p.second + d[1]
          if (r < 0 || c < 0 || r >= grid.size || c == grid[0].size || grid[r][c] != 1) {
            continue
          }
          queue.offer(Pair(r, c))
          grid[r][c] = 2
        }
      }

      min++
    }

    // checking fresh oranges
    for (array in grid) {
      for (element in array) {
        if (element == 1) return -1
      }
    }

    return min
  }
}
