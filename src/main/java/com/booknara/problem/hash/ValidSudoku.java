package com.booknara.problem.hash;

import java.util.*;

/**
 * 36. Valid Sudoku (Medium)
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
  // T:O(1), S:O(1)
  public boolean isValidSudoku(char[][] board) {
    // row (0 ~ 8)
    Map<Integer, Set<Integer>> row = new HashMap<>();
    // col (0 ~ 8)
    Map<Integer, Set<Integer>> col = new HashMap<>();
    // block (0 ~ 8)
    Map<Integer, Set<Integer>> block = new HashMap<>();

    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') continue;

        int num = board[i][j] - '0';
        // row
        Set<Integer> set1 = row.getOrDefault(i, new HashSet<>());
        if (set1.contains(num)) {
          return false;
        }
        set1.add(num);
        row.put(i, set1);

        // col
        Set<Integer> set2 = col.getOrDefault(j, new HashSet<>());
        if (set2.contains(num)) {
          return false;
        }
        set2.add(num);
        col.put(j, set2);

        // block
        int b = getBlock(i, j);
        Set<Integer> set3 = block.getOrDefault(b, new HashSet<>());
        if (set3.contains(num)) {
          return false;
        }
        set3.add(num);
        block.put(b, set3);
      }
    }

    return true;
  }

  public int getBlock(int i, int j) {
    // (0,0) -> 0
    // (0,1) -> 0
    // (0,2) -> 0
    // (0,3) -> 1
    // (1,0) -> 3
    // (8,8) -> 8
    // (8,0) -> 6
    // (5, 3) -> 4
    return (i / 3 * 3) + (j / 3);
  }

  // T:O(1), S:O(1)
  public boolean isValidSudoku1(char[][] board) {
    int n = board.length;
    List<Set<Character>> rows = new ArrayList<>();
    List<Set<Character>> cols = new ArrayList<>();
    List<Set<Character>> grids = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      rows.add(new HashSet<>());
      cols.add(new HashSet<>());
      grids.add(new HashSet<>());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c = board[i][j];
        if (c == '.') continue;
        // row
        if (rows.get(i).contains(c)) {
          return false;
        } else {
          rows.get(i).add(c);
        }
        // col
        if (cols.get(j).contains(c)) {
          return false;
        } else {
          cols.get(j).add(c);
        }
        // grid
        int grid = getGrid(i, j);
        if (grids.get(grid).contains(c)) {
          return false;
        } else {
          grids.get(grid).add(c);
        }
      }
    }
    return true;
  }

  public int getGrid(int r, int c) {
    int row = 0, col = 0;
    if (r >= 0 && r < 3) { // 0,1,2
      row = 0;
    } else if (r >= 3 && r < 6) {   // 3,4,5
      row = 1;
    } else {    // 6,7,8
      row = 2;
    }

    if (c >= 0 && c < 3) { // 0,1,2
      col = 0;
    } else if (c >= 3 && c < 6) {   // 3,4,5
      col = 1;
    } else {    // 6,7,8
      col = 2;
    }

    return row * 3 + col;
  }
}
