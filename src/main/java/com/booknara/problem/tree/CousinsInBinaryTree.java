package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree (Easy)
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        int xDepth = -1, yDepth = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int depth = 0;
        if (root.val == x) {
            xDepth = 0;
        } else if (root.val == y) {
            yDepth = 0;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                depth++;
                queue.offer(null);
                continue;
            }

            boolean xFound = false, yFound = false;
            if (node.left != null) {
                queue.offer(node.left);
                if (node.left.val == x) {
                    xDepth = depth + 1;
                    xFound = true;
                } else if (node.left.val == y) {
                    yDepth = depth + 1;
                    yFound = true;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (node.right.val == x) {
                    xDepth = depth + 1;
                    xFound = true;
                } else if (node.right.val == y) {
                    yDepth = depth + 1;
                    yFound = true;
                }
            }

            if (xDepth != -1 && yDepth != -1) {
                if (xFound && yFound) return false;
                return xDepth == yDepth;
            }
        }

        return false;
    }
}
