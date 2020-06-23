package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. Count Complete Tree Nodes (Medium)
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {
    // T:O(n), S:O(logn)
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res++;

            if (node.left == null) {
                res += queue.size();
                break;
            }
            queue.offer(node.left);

            if (node.right == null) {
                res += queue.size();
                break;
            }

            queue.offer(node.right);
        }

        return res;
    }
}
