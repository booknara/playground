package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers (Medium)
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
    // input : Binary tree
    // output : Sum all the numbers which can be constructed from top to leaf
    // T:O(n), S:O(h)
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // input check (null)
        // NOTE : the value of root node can't be 0, but the test case allows to have 0)
        //if (root == null || root.val == 0) return 0;
        if (root == null) return 0;

        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int cur) {
        if (node.left == null && node.right == null) {
            //System.out.println(cur);
            sum += cur * 10 + node.val;
            return;
        }

        cur = cur * 10 + node.val;
        if (node.left != null) {
            dfs(node.left, cur);
        }

        if (node.right != null) {
            dfs(node.right, cur);
        }
    }

    public int sumNumbers1(TreeNode root) {
        // input check (null)
        if (root == null) return 0;

        // what if root.val is 0?
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return sum;
    }

    public void dfs(TreeNode node, StringBuilder builder) {
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            //System.out.println(builder.toString());
            sum += Integer.parseInt(builder.toString());
            return;
        }

        if (node.left != null) {
            dfs(node.left, new StringBuilder(builder.toString()));
        }

        if (node.right != null) {
            dfs(node.right, new StringBuilder(builder.toString()));
        }
    }
}
