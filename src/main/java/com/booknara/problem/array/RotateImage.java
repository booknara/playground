package com.booknara.problem.array;

/**
 * 48. Rotate Image (Medium)
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    // T:O(n^2), S:O(1)
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        // (i, j) -> (j, n - 1 - i)
        // Step 1: (i, j) -> (j, i)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: (j, i) -> (j, n - 1 - i)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // T:O(n^2), S:O(1)
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        int last = n - 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[last - j][i];
                matrix[last - j][i] = matrix[last - i][last - j];
                matrix[last - i][last - j] = matrix[j][last - i];
                matrix[j][last - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
/**
 Input: matrix = [
 [1,2,3]
 [4,5,6]
 [7,8,9]

 [7,4,1]
 [8,5,2]
 [9,6,3]
 ]

 (0,0)
 temp = (2,0)
 (2,0) = (2,2)
 (2,2) = (0,2)
 (0,2) = (0,0)
 (0,0) = temp

 Output: [[7,4,1],[8,5,2],[9,6,3]]
 */