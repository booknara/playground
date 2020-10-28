package com.booknara.problem.dfs;

/**
 * 529. Minesweeper (Medium)
 * https://leetcode.com/problems/minesweeper/
 */
public class Minesweeper {
    // 8 directions
    int[][] dirs = new int[][] {
            {-1, -1},
            {-1, 0},
            {-1, 1},

            {0, -1},
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1}
    };
    // T:O(m*n), S:O(1)
    public char[][] updateBoard(char[][] board, int[] click) {
        // input check
        if (board == null || board.length == 0) return board;

        int r = click[0];
        int c = click[1];

        // (r,c) is 'M' -> 'X'
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        if (board[r][c] == 'E') {
            updateCell(board, r, c);
        }

        return board;
    }

    public void updateCell(char[][] board, int r, int c) {
        // base case
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if (board[r][c] != 'E') return;

        int count = getMineNearBy(board, r, c);
        if (count == 0) {
            // no mine
            board[r][c] = 'B';
            for (int[] dir: dirs) {
                // 8 directions
                int newR = r + dir[0];
                int newC = c + dir[1];
                updateCell(board, newR, newC);
            }
        } else {
            board[r][c] = (char)(count + '0');
        }
    }


    public int getMineNearBy(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;
        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR < 0 || newC < 0 || newR >= m || newC >= n) continue;   // out of range

            if (board[newR][newC] == 'M') count++;
        }

        return count;
    }
}
/**
 M -> unrevealed mine
 E -> unrevealed empty square
 B -> revealed blank square without any mine nearby
 1 ~ 8 -> how many mines are adjacent to this revealed square
 X -> revealed mine

 int[] click -> r = click[0], c = click[1]
 click coordinate should be 'M' or 'E'
 If (r,c) is 'M' -> change it to 'X'
 If (r,c) is 'E' with no adjacent mines -> change it to B and
 */