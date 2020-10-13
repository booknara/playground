package com.booknara.problem.dfs;

/**
 * 419. Battleships in a Board (Medium)
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class BattleshipsInBoard {
    // T:O(n^2), S:O(1)
    public int countBattleships(char[][] board) {
        // input check
        if (board == null || board.length == 0) return 0;

        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;

                // Find the first battleship by checking whether top and left element is out of range or '.'
                if ((i - 1 < 0 || board[i - 1][j] == '.')
                        && (j - 1 < 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    // T:O(n^2), S:O(1)
    public int countBattleships1(char[][] board) {
        // input check
        if (board == null || board.length == 0) return 0;

        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.') return;

        board[r][c] = '.';

        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(board, newR, newC);
        }
    }
}
