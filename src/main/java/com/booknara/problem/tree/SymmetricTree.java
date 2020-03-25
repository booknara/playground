package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 101. Symmetric Tree (Easy)
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }

    Map<Integer, List<Integer>> memo = new HashMap<>();
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        dfs(root, 1);
        for (Map.Entry<Integer, List<Integer>> entry: memo.entrySet()) {
            if (!palindrome(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            List list = memo.getOrDefault(level, new ArrayList<Integer>());
            list.add(null);
            memo.put(level, list);
            return;
        }

        List list = memo.getOrDefault(level, new ArrayList<>());
        list.add(node.val);
        memo.put(level, list);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public boolean palindrome(List<Integer> list) {
        int s = 0, e = list.size() - 1;
        while (s <= e) {
            if(list.get(s) != list.get(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
