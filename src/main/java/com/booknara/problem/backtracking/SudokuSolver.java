package com.booknara.problem.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 37. Sudoku Solver (Hard)
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    Map<Integer, Set<Integer>> row = new HashMap<>();
    Map<Integer, Set<Integer>> col = new HashMap<>();
    Map<Integer, Set<Integer>> block = new HashMap<>();
    boolean solved = false;

    // T:O(1), S:(1) -> T:O(9!)^9, S:O(1)
    public void solveSudoku(char[][] board) {
        // input check
        if (board == null || board.length == 0) return;

        init(board);
        backtracking(board, 0, 0);
    }

    // main backtracking logic
    public void backtracking(char[][] board, int r, int c) {
        // there are two cases ('.' or 'number')
        if (board[r][c] == '.') {
            for (int n = 1; n < 10; n++) {
                if (couldSolve(board, r, c, n)) {
                    fillNumber(board, r, c, n);
                    fillNextNumber(board, r, c);
                    if (!solved) removeNumber(board, r, c, n);
                }
            }
        } else {
            fillNextNumber(board, r, c);
        }
    }

    public void fillNumber(char[][] board, int r, int c, int num) {
        // insert i
        board[r][c] = (char)('0' + num);
        Set<Integer> l1 = row.getOrDefault(r, new HashSet<>());
        l1.add(num);
        row.put(r, l1);

        Set<Integer> l2 = col.getOrDefault(c, new HashSet<>());
        l2.add(num);
        col.put(c, l2);

        Set<Integer> l3 = block.getOrDefault(getBlock(r, c), new HashSet<>());
        l3.add(num);
        block.put(getBlock(r, c), l3);
    }

    public void fillNextNumber(char[][] board, int r, int c) {
        if (r == board.length - 1 && c == board[r].length - 1) {
            solved = true;
            return;
        }

        // there are two cases in terms of next column availability
        if (c == board[r].length - 1) {
            backtracking(board, r + 1, 0);
        } else {
            backtracking(board, r, c + 1);
        }
    }

    public void removeNumber(char[][] board, int r, int c, int num) {
        // delete board[r][c] = 'num' -> '.'
        Set<Integer> s1 = row.getOrDefault(r, new HashSet<>());
        s1.remove(num);
        row.put(r, s1);

        Set<Integer> s2 = col.getOrDefault(c, new HashSet<>());
        s2.remove(num);
        col.put(c, s2);

        Set<Integer> s3 = block.getOrDefault(getBlock(r, c), new HashSet<>());
        s3.remove(num);
        block.put(getBlock(r, c), s3);
        board[r][c] = '.';
    }

    public boolean couldSolve(char[][] board, int r, int c, int num) {
        // Edge case which row or col or block are empty
        if (row.get(r) != null && row.get(r).contains(num)) return false;
        if (col.get(c) != null && col.get(c).contains(num)) return false;
        if (block.get(getBlock(r, c)) != null && block.get(getBlock(r, c)).contains(num)) return false;

        return true;
    }

    public void init(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';
                // row
                Set<Integer> r = row.getOrDefault(i, new HashSet<>());
                r.add(num);
                row.put(i, r);
                // col
                Set<Integer> c = col.getOrDefault(j, new HashSet<>());
                c.add(num);
                col.put(j, c);
                // block
                int bIdx = getBlock(i, j);
                Set<Integer> b = block.getOrDefault(bIdx, new HashSet<>());
                b.add(num);
                block.put(bIdx, b);
            }
        }
    }

    public int getBlock(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
