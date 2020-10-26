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
}
