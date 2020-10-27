package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. Print Binary Tree (Medium)
 * https://leetcode.com/problems/print-binary-tree/
 */
public class PrintBinaryTree {
    // T:O(n), S:O(h, except for output list)
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;

        int height = getHeight(root);
        int m = height;
        int n = (int)Math.pow(2, m) - 1;
        // System.out.println(m);
        // System.out.println(n);

        // init
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }

        fillValue(root, 0, m, 0, n - 1, res);
        return res;
    }

    // root, 0, 2, 0, 3
    public void fillValue(TreeNode node, int currentRow, int endRow, int startCol, int endCol,
                          List<List<String>> res) {
        // base case
        if (node == null) return;
        if (currentRow == endRow) return;

        int c = startCol + (endCol - startCol) / 2;
        res.get(currentRow).set(c, String.valueOf(node.val));    // root
        // left (start, mid - 1)
        fillValue(node.left, currentRow + 1, endRow, startCol, c - 1, res);
        // right (mid + 1, end)
        fillValue(node.right, currentRow + 1, endRow, c + 1, endCol, res);
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;

        return Math.max(getHeight(node.left) + 1, getHeight(node.right) + 1);
    }
}
/**
 m * n =>
 row(m) : height
 col(n) : odd number -> Math.pow(2, height) - 1
 height 2 -> 2^2 - 1 = 3
 height 3 -> 2^3 - 1 = 7
 height 4 -> 2^4 - 1 = 15

 1. get the height
 2. get the width by the height
 3. init the result array with empty string("")
 4. preorder traverse
 left child, right child -> row + 1
 left, right (root index - 1) left(root index + 1), right

 if (root == null) return;


 root -> middle of the first row
 left bottom   |   right bottom
 (same size)         (same size)

 */