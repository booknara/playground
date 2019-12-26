package com.booknara.problem.dp;

/** Hacker Rank : Hard
 * https://www.hackerrank.com/contests/srin-aadc03/challenges/classic-01-knapsack/problem
 * This is the classic & famous knapsack problem :
 * You are a thief carrying a single knapsack with limited (1 <= S <= 2000) capacity.
 * The museum you stole had (1 <= N <= 2000) artifact that you could steal.
 * Unfortunately you might not be able to steal all the artifact because of your limited knapsack capacity.
 *
 * You have to cherry pick the artifact in order to maximize the total value (<= 2000000) of the artifacts you stole.
 */
public class ClassicKnapSack {

    // Time complexity: O(nm), Space complexity: O(nm)
    public int getHighestValue(int[] weight, int[] value, int capacity) {
        int[][] matrix = new int[weight.length + 1][capacity + 1];

        int item = weight.length;
        initMatrix(matrix, capacity, item);
        for (int i = 1; i < item + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int prevMax = matrix[i - 1][j];
                int currMax = 0;

                int w = weight[i - 1];              // weight of current item
                if (j >= w) {
                    currMax = value[i - 1];         // value of current item
                    int remainingWeight = j - w;    // add extra value from the remaining capacity
                    currMax += matrix[i - 1][remainingWeight];
                }

                matrix[i][j] = Math.max(prevMax, currMax);  // compare the final value btw the previous and new values
            }
        }

        System.out.println();
        print2DMatrix(matrix, capacity, item);
        return matrix[weight.length][capacity];
    }

    // Time complexity: O(nm), Space complexity: O(m)
    public int getHighestValue2(int[] weight, int[] value, int capacity) {
        int[] matrix = new int[capacity + 1];

        int item = weight.length;
        for (int i = 1; i < item + 1; i++) {
            for (int j = capacity; j >= 1; j--) {
                int prevMax = matrix[j];
                int currMax = 0;

                int w = weight[i - 1];              // weight of current item
                if (j >= w) {
                    currMax = value[i - 1];         // value of current item
                    int remainingWeight = j - w;    // add extra value from the remaining capacity
                    currMax += matrix[remainingWeight];
                }

                matrix[j] = Math.max(prevMax, currMax);  // compare the final value btw the previous and new values
            }

            print1DMatrix(matrix, capacity);
        }

        System.out.println();
        return matrix[capacity];
    }

    private void initMatrix(int[][] matrix, int capacity, int item) {
        for (int i = 0; i < capacity + 1; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 0; i < item + 1; i++) {
            matrix[i][0] = 0;
        }

        //print2DMatrix(matrix, capacity, item);
    }

    private void print1DMatrix(int[] matrix, int capacity) {
        for (int j = 0; j < capacity + 1; j++) {
            System.out.printf("%4d", matrix[j]);
        }
        System.out.println();
    }

    private void print2DMatrix(int[][] matrix, int capacity, int item) {
        for (int i = 0; i < item + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
