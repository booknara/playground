package com.booknara.problem.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 130. Surrounded Regions (Medium)
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    // T:O(n^2), S:O(n^2)
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

    // T:O(n^2), S:O(n^2)
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    // only board
                    if (board[i][j] == 'O') {
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];
                board[r][c] = 'M';

                for (int[] dir: dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR < 0 || newR >= m || newC < 0 || newC >= n || board[newR][newC] != 'O') {
                        continue;
                    }

                    q.offer(new int[] {newR, newC});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
/**
 X X X X
 X O O X
 X X O X
 X O X X

 BFS
 0 -> M (mark)

 After BFS, update the character
 M -> O
 O -> X
 */