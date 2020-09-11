package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. Range Sum of BST (Easy)
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    int sum = 0;
    // T:O(n), S:O(h)
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node == null) return;

        // inclusive
        if (node.val >= L && node.val <= R) {
            //System.out.println(node.val);
            sum += node.val;
        }

        // Keep deep down to left node if node.val is bigger than L
        if (L < node.val) dfs(node.left, L, R);
        // Keep deep down to right node if node.val is smaller than R
        if (node.val < R) dfs(node.right, L, R);
    }

    // iterative method. Time: O(n), Space: O(h), height of BST
    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (L <= node.val && node.val <= R) {
                    sum += node.val;
                }

                if (L < node.val && node.left != null) {
                    q.offer(node.left);
                }

                if (node.val < R && node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return sum;
    }

}
