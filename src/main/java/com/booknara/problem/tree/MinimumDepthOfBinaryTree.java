package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree (Easy)
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    // T:O(n), S:O(n)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            level++;
        }

        return -1;
    }
}
/**
 3
 / \
 9  20
 /  \
 15   7

 1. The minimum depth = to find the node that has left and right chilrend node null
 2. Level order(BFS)
 */