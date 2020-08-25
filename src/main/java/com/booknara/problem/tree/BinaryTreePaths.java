package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths (Easy)
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    // T:O(n), S:(h)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root, new StringBuilder(), res);
        return res;
    }

    public void dfs(TreeNode node, StringBuilder builder, List<String> res) {
        // base case
        if (node == null) return;

        if (node.left == null && node.right == null) {
            builder.append(node.val);
            res.add(builder.toString());
            return;
        }

        builder.append(node.val);
        builder.append("->");
        dfs(node.left, new StringBuilder(builder.toString()), res);
        dfs(node.right, new StringBuilder(builder.toString()), res);
    }
}
