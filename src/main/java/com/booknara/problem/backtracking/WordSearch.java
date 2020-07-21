package com.booknara.problem.backtracking;

/**
 * 79. Word Search (Medium)
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
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
        boolean found = (dfs(board,i - 1, j, word, index + 1)
                || dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1));
        // Non character -> character
        board[i][j] ^= 256;

        return found;
    }
}
