package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 311. Sparse Matrix Multiplication (Medium)
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 */
public class SparseMatrixMultiplication {
    // T:O(n*m), S:O(n*m)
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length * B.length == 0) return new int[0][0];
        if (A[0].length != B.length) return new int[0][0];

        // Sparse matrix
        List<Node> listA = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0){
                    listA.add(new Node(i, j, A[i][j]));
                }
            }
        }

        List<Node> listB = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] != 0){
                    listB.add(new Node(i, j, B[i][j]));
                }
            }
        }

        int[][] result = new int[A.length][B[0].length];
        for (Node a: listA) {
            for (Node b: listB) {
                // e.g. A(2,3) X B(3,1) = (2,1)
                if (a.c == b.r) {
                    result[a.r][b.c] += a.val * b.val;
                }
            }
        }

        return result;
    }

    static class Node {
        int r;
        int c;
        int val;

        Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    // T:O(n*m*k), S:O(n*m)
    public int[][] multiply1(int[][] A, int[][] B) {
        if (A.length * B.length == 0) return new int[0][0];
        if (A[0].length != B.length) return new int[0][0];

        int[][] result = new int[A.length][B[0].length];

        // A - row
        for (int i = 0; i < A.length; i++) {
            // B - column
            for (int j = 0; j < B[0].length; j++) {
                int val = 0;
                // A- column
                for (int k = 0; k < A[0].length; k++) {
                    val += (A[i][k] * B[k][j]);
                }
                result[i][j] = val;
            }
        }

        return result;
    }
}

/**
 A = [] (i, j)
 B = [] (i, j)

 (2,3) X (3,3) = (2,3)
 A = 0,0 0,1 0,2
 1,0 1,1 1,2

 B = 0,0 0,1 0,2
 1,0 1,1 1,2
 2,0 2,1 2,2

 A X B = 0 ~ n => sum (A(0,j) x B(j, 0)) = (0,0)
 int[][] result = new int[A.length][B[0].length];
 for (int i = 0; i < A.length; i++) {
 for (int j = 0; j < B[0].length; j++) {

 result[i][j] =
 }
 }
 */