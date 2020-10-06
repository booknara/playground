package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. Even Odd Tree (Medium)
 * https://leetcode.com/problems/even-odd-tree/
 */
public class EvenOddTree {
    // T:O(n), S:O(n)
    public boolean isEvenOddTree(TreeNode root) {
        // input check
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);  // 1
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // odd level -> decrease, even level -> increase
            // Integer.MAX_VALUE = 2147483647 (odd)
            // Integer.MIN_VALUE = -2147483648 (even)
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size > 0) {
                TreeNode n = q.poll();  // 1, level = 0
                if (level % 2 == 0) {
                    // even (increase)
                    if (n.val % 2 == 0 || prev >= n.val) return false;
                } else {
                    // odd (decrease)
                    if (n.val % 2 == 1 || prev <= n.val) return false;
                }

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
                prev = n.val;
                size--;
            }

            level++;
        }

        return true;
    }
}
/**
 odd level -> descrease
 even level -> increase

 e        o
 [1] -> [10,4] -> [3,7,9] -> [12,8,6,2]

 */