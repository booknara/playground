package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leet code: 94. Binary Tree Inorder Traversal(Medium)
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    // Time complexity: O(N), Space complexity: worst O(N), average O(logN)
    public List<Integer> inorderTraversalWithRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        traverse(root, res);

        return res;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    // Time complexity: O(N), Space complexity: O(N)
    public List<Integer> inorderTraversalWithIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

}
