package com.booknara.problem.array;

/**
 * 348. Design Tic-Tac-Toe (Medium)
 * https://leetcode.com/problems/design-tic-tac-toe/
 */
public class TicTacToe {
    int[][] grid;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        grid = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        grid[row][col] = player;
        boolean win = true;
        // check row(horizontal)
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == 0 || grid[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        // check col(vertical)
        win = true;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0 || grid[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;

        // two diagonal cases
        int i = 0, j = 0;
        win = true;
        while (i < grid.length && j < grid.length) {
            if (grid[i][j] == 0 || grid[i][j] != player) {
                win = false;
                break;
            }
            i++;
            j++;
        }
        if (win) return player;

        i = 0;
        j = grid.length - 1;
        win = true;
        while (i < grid.length && j >= 0) {
            if (grid[i][j] == 0 || grid[i][j] != player) {
                win = false;
                break;
            }
            i++;
            j--;
        }
        if (win) return player;

        return 0;
    }
}
