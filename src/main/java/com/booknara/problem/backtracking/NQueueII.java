package com.booknara.problem.backtracking;

/**
 *
 */
public class NQueueII {
    int count = 0;
    // Time Complexity: O(n!)
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] hills = new boolean[n * 2];
        boolean[] dales = new boolean[n * 2];
        backtracking(0, cols, hills, dales, n);

        return count;
    }

    public void backtracking(int row,
                             boolean[] cols,
                             boolean[] hills,
                             boolean[] dales,
                             int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // (1,2) -> Hill(\) diagonal index : next row (2,3), 2 - 3 + 4 = 3, next row (1,0), 1 - 0 + 4 = 5
            int hillIdx = row - col + n;
            // (1,2) -> Dale(/) diagonal index : next row (2,1)
            int daleIdx = row + col;
            if (cols[col] || hills[hillIdx] || dales[daleIdx]) continue;

            cols[col] = true;
            hills[hillIdx] = true;
            dales[daleIdx] = true;
            backtracking(row + 1, cols, hills, dales, n);
            cols[col] = false;
            hills[hillIdx] = false;
            dales[daleIdx] = false;
        }
    }

    public int totalNQueens1(int n) {
        int[] rows = new int[n];
        int[] hills = new int[4 * n - 1];
        int[] dales = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }

    public int backtrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (safe(row, col, n, rows, hills, dales)) {
                // place queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;
                dales[row + col] = 1;

                if (row + 1 == n) {
                    count++;
                } else {
                    count = backtrack(row + 1, count, n, rows, hills, dales);
                }

                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }

        return count;
    }

    public boolean safe(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }
}
