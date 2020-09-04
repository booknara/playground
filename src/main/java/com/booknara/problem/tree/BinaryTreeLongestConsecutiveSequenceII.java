package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 549. Binary Tree Longest Consecutive Sequence II (Medium)
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;
    // T:O(n), S:(h)
    public int longestConsecutive(TreeNode root) {
        if (root == null) return max;

        dfs(root);
        return max;
    }

    public Element dfs(TreeNode node) {
        // base case
        if (node == null) return new Element(0, 0);

        int inr = 1, dcr = 1;
        if (node.left != null) {
            Element left = dfs(node.left);

            // check whether it's consecutive sequence
            if (node.left.val + 1 == node.val) {
                // decreasing from parent to child
                dcr = left.decreased + 1;
            } else if (node.left.val - 1 == node.val) {
                inr = left.increased + 1;
            }
        }

        if (node.right != null) {
            Element right = dfs(node.right);

            if (node.right.val + 1 == node.val) {
                // decreasing from parent to child
                dcr = Math.max(dcr, right.decreased + 1);
            } else if (node.right.val - 1 == node.val) {
                inr = Math.max(inr, right.increased + 1);
            }
        }

        max = Math.max(max, dcr + inr - 1);

        return new Element(inr, dcr);
    }

    static class Element {
        int increased;
        int decreased;
        Element(int increased, int decreased) {
            this.increased = increased;
            this.decreased = decreased;
        }
    }
}
