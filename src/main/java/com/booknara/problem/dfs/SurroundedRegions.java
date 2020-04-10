package com.booknara.problem.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 130. Surrounded Regions (Medium)
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rowMax = board.length;
        int colMax = board[0].length;
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (i == 0 || i == rowMax - 1 || j == 0 || j == colMax - 1) {
                    // Border
                    if (board[i][j] == 'O') {
                        list.add(new Cell(i, j));
                    }
                } else {
                    // Center
                    if (board[i][j] == 'O') {
                        board[i][j] = 'Y';
                    }
                }
            }
        }

        for (Cell c: list) {
            dfs(board, c.i, c.j);
        }

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        board[i][j] = 'O';
        // Top
        if (i > 0 && board[i - 1][j] == 'Y') {
            dfs(board, i - 1, j);
        }
        // Bottom
        if (i < board.length - 1 && board[i + 1][j] == 'Y') {
            dfs(board, i + 1, j);
        }
        // Left
        if (j > 0 && board[i][j - 1] == 'Y') {
            dfs(board, i, j - 1);
        }
        // Right
        if (j < board[0].length - 1 && board[i][j + 1] == 'Y') {
            dfs(board, i, j + 1);
        }
    }

    class Cell {
        int i;
        int j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
