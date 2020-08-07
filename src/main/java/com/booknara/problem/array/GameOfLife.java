package com.booknara.problem.array;

/**
 * 289. Game of Life (Medium)
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {
    // T:O(n^2), S:O(1)
    public void gameOfLife(int[][] board) {
        // input check
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = getLiveCell(board, i, j);
                if (board[i][j] < 1) {
                    // dead cell
                    if (live == 3) board[i][j] = -1;
                } else {
                    // live cell
                    if (live < 2) board[i][j] = 2;
                    else if (live == 2 || live == 3) board[i][j] = 1;
                    else if (live > 3) board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int getLiveCell(int[][] board, int i , int j) {
        int count = 0;
        int maxRow = board.length, maxCol = board[0].length;
        if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1) count++;
        if (i > 0 && board[i - 1][j] >= 1) count++;
        if (i > 0 && j < maxCol - 1 && board[i - 1][j + 1] >= 1) count++;

        if (j > 0 && board[i][j - 1] >= 1) count++;
        if (j < maxCol - 1 && board[i][j + 1] >= 1) count++;

        if (i < maxRow - 1 && j > 0 && board[i + 1][j - 1] >= 1) count++;
        if (i < maxRow - 1 && board[i + 1][j] >= 1) count++;
        if (i < maxRow - 1 && j < maxCol - 1 && board[i + 1][j + 1] >= 1) count++;

        return count;
    }
}

// rule
// 1. live cell -> the number of neighbor live cells < 2 -> dead
// 2. live cell -> the number of neighbor live cells == 2 or 3 -> live
// 3. live cell -> the number of neighbor live cells > 3 -> dead
// 4. dead cell -> the number of neighbor live cells == 3 -> live

// dead cell (0) -> become live cell(-1) => dead cell < 1
// live cell (1) -> become dead cell(2) => live cell >= 1
