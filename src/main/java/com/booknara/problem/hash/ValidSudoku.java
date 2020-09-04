package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku (Medium)
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    // T:O(1), S:O(1)
    public boolean isValidSudoku(char[][] board) {
        // input check
        // assume board is 9X9

        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> block = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    /// row init
                    Set rSet = row.getOrDefault(i, new HashSet<>());
                    if (rSet.contains(board[i][j] - '0')) {
                        System.out.println("1");
                        return false;
                    }
                    rSet.add(board[i][j] - '0');
                    row.put(i, rSet);

                    // col init
                    Set cSet = col.getOrDefault(j, new HashSet<>());
                    if (cSet.contains(board[i][j] - '0')) {
                        System.out.println("1");
                        return false;
                    }

                    cSet.add(board[i][j] - '0');
                    col.put(j, cSet);

                    // block init (0 ~ 9)
                    int c = j / 3;
                    int r = (i / 3) * 3;
                    // [0, 0] -> 0, [0, 1] -> 1, [1, 0] -> 3, [6,7] -> 9
                    Set bSet = block.getOrDefault(r + c, new HashSet<>());
                    if (bSet.contains(board[i][j] - '0')) {
                        System.out.println("2");
                        return false;
                    }

                    bSet.add(board[i][j] - '0');
                    block.put(r + c, bSet);
                }
            }
        }

        return true;
    }
}
