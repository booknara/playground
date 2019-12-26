package com.booknara.problem.dc;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int s = 0;
        int e = matrix.length;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (matrix[m][0] == target) {
                return true;
            }

            if (matrix[m][0] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        for (int i = 0; i < e; i++) {
            System.out.println(i);
            if (searchRow(matrix[i], target)) {
                return true;
            }
        }

        return false;
    }

    private boolean searchRow(int[] array, int target) {
        if (array[array.length - 1] < target) {
            return false;
        }

        if (array[array.length - 1] == target) {
            return true;
        }

        int s = 0;
        int e = array.length;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (array[m] == target) {
                return true;
            }

            if (array[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return false;
    }
}
