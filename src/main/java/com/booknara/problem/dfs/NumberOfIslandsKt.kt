package com.booknara.problem.dfs

/**
 * 200. Number of Islands (Medium)
 * https://leetcode.com/problems/number-of-islands/
 */
class NumberOfIslandsKt {
  // T:O(n^2), S:O(n+m due to callstack)
  fun numIslands(grid: Array<CharArray>): Int {
    var count = 0

    for (i in grid.indices) {
      for (j in grid[i].indices) {
        if (grid[i][j] == '0') continue

        count++
        // DFS
        visitIsland(grid, i, j)
      }
    }

    return count
  }

  fun visitIsland(grid: Array<CharArray>, row: Int, col: Int) {
    if (row < 0 || col < 0 || row >= grid.size || col >= grid[row].size || grid[row][col] == '0') {
      return
    }

    // println("$row, $col")
    grid[row][col] = '0'
    visitIsland(grid, row - 1, col) // up
    visitIsland(grid, row + 1, col) // down
    visitIsland(grid, row, col - 1) // left
    visitIsland(grid, row, col + 1) // right
  }
}