package com.booknara.problem.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // System.out.println(board[i][j]);
                    // Early termination
                    if (dfs(board, 0, i, j, word)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int index, int i, int j, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }

        // Character comparision
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // character -> Non character because it makes false when the following Character comparision happens(visited trick)
        board[i][j] ^= 256;
        boolean found = (dfs(board, index + 1, i - 1, j, word)
                || dfs(board, index + 1, i + 1, j, word)
                || dfs(board, index + 1, i, j - 1, word)
                || dfs(board, index + 1, i, j + 1, word));
        // Non character -> character
        board[i][j] ^= 256;

        return found;
    }
}
