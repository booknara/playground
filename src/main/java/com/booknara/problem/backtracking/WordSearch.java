package com.booknara.problem.backtracking;

/**
 * 79. Word Search (Medium)
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
  int[][] directions = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1},
  };

  // T:O(N*3^L), S:O(L)
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          // System.out.println(board[i][j]);
          // Early termination
          if (dfs(board, i, j, word, 0)) return true;
        }
      }
    }

    return false;
  }

  public boolean dfs(char[][] board, int i, int j, String word, int index) {
    if (index == word.length()) {
      return true;
    }

    // out of range
    if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
      return false;
    }

    // Character comparision
    if (board[i][j] != word.charAt(index)) {
      return false;
    }

    // character -> Non character because it makes false when the following Character comparision happens(visited trick)
    board[i][j] ^= 256;
    boolean found = (dfs(board, i - 1, j, word, index + 1)
        || dfs(board, i + 1, j, word, index + 1)
        || dfs(board, i, j - 1, word, index + 1)
        || dfs(board, i, j + 1, word, index + 1));
    // Non character -> character
    board[i][j] ^= 256;

    return found;
  }

  // T:O(N*3^L), S:O(n^2)
  public boolean exist1(char[][] board, String word) {
    // edge case
    if (word.length() == 0) {
      return true;
    }

    int n = board.length;
    int m = board[0].length;
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (dfs1(board, i, j, 0, word, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean dfs1(char[][] board, int r, int c, int index, String word, boolean[][] visited) {
    if (index == word.length()) {
      return true;
    }

    if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
        || board[r][c] != word.charAt(index) || visited[r][c]) {
      return false;
    }

    visited[r][c] = true;
    for (int[] d : directions) {
      if (dfs1(board, r + d[0], c + d[1], index + 1, word, visited)) {
        return true;
      }
    }
    visited[r][c] = false;

    return false;
  }
}
