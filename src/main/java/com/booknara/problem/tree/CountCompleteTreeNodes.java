package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. Count Complete Tree Nodes (Medium)
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {
    // T:O(logd*logd), S:O(logn)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int res = 0;
        // 1. compare left side height + right side height
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);
        // 2. if the heights are same, it's a perfect tree
        if (leftHeight == rightHeight) {
            // the number of the nodes are 2^(height + 1) - 1
            return (1 << leftHeight) - 1;
        }
        // 3. if the heights are different, plus 1(root) and count left/right sides
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getHeight(TreeNode node, boolean left) {
        int res = 0;
        while (node != null) {
            res++;
            if (left) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return res;
    }

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
