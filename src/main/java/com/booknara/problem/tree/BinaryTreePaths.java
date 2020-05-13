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
        if (root == null) {
            return res;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        dfs(root, builder, res);
        return res;
    }

    public void dfs(TreeNode node, StringBuilder s, List<String> list) {
        if (node.left == null && node.right == null) {
            list.add(s.toString());
        }

        if (node.left != null) {
            StringBuilder builder = new StringBuilder(s.toString());
            builder.append("->").append(node.left.val);
            dfs(node.left, builder, list);
        }

        if (node.right != null) {
            StringBuilder builder = new StringBuilder(s.toString());
            builder.append("->").append(node.right.val);
            dfs(node.right, builder, list);
        }
    }
}
