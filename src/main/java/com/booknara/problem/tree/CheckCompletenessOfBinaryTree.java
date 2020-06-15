package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree (Medium)
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class CheckCompletenessOfBinaryTree {
    // T:O(n), S:O(h)
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        // check whether there is the second time null
        boolean found = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                found = true;
                continue;
            }

            if (found) return false;
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;
    }

    // T:O(n), S:O(h)
    public boolean isCompleteTree1(TreeNode root) {
        if (root == null) return true;

        // get the count of nodes until reaching the first null
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            }
            count++;
            queue.offer(node.left);
            queue.offer(node.right);
        }

        //System.out.println(count);

        // get the total number of nodes
        int num = 0;
        queue.clear();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            num++;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return count == num;
    }

}
