package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 897. Increasing Order Search Tree (Easy)
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {
    // T:O(n), S:O(n)
    public TreeNode increasingBST(TreeNode root) {
        // input check
        if (root == null) return null;

        // in-order traverse(iterative)
        Queue<Integer> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                //System.out.println(cur.val);
                queue.offer(cur.val);
                cur = cur.right;
            }
        }

        TreeNode res = new TreeNode(0);
        TreeNode cursor = res;
        while (!queue.isEmpty()) {
            cursor.right = new TreeNode(queue.poll());
            cursor = cursor.right;
        }

        return res.right;
    }
}
