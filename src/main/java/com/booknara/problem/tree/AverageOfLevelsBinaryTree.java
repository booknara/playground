package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree (Easy)
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsBinaryTree {
    List<Integer> count = new ArrayList<>();
    List<Double> sum = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, 0);

        for (int i = 0; i < count.size(); i++) {
            res.add(sum.get(i) / count.get(i));
        }

        return res;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (count.size() <= level) {
            count.add(0);
            sum.add(0.0);
        }

        count.set(level, count.get(level) + 1);
        sum.set(level, sum.get(level) + node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
