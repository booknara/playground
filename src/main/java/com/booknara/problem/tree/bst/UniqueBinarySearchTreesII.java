package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II (Medium)
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
    // T:O(n*Gn), S:O(n*Gn), n*Gn=4^n/n^1/2
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return dfs(1, n);
    }

    public List<TreeNode> dfs(int lower, int higher) {
        List<TreeNode> list = new ArrayList<>();
        if (lower > higher) {
            list.add(null);
            return list;
        }

        for (int i = lower; i <= higher; i++) {
            List<TreeNode> left = dfs(lower, i - 1);
            List<TreeNode> right = dfs(i + 1, higher);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    list.add(n);
                }
            }
        }

        return list;
    }
}
