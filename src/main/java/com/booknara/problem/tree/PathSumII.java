package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II (Medium)
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    List<List<Integer>> ans;

    // #1 Solution : 3/3/2020
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();

        dfs(root, new ArrayList<>(), sum);

        return ans;
    }

    public void dfs(TreeNode node, List<Integer> path, int remaining) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null && remaining == node.val) {
            ans.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        dfs(node.left, path, remaining - node.val);
        dfs(node.right, path, remaining - node.val);

        path.remove(path.size() - 1);
    }

    // #2 Solution : 3/21/2020
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, list, 0, sum);

        return ans;
    }

    public void dfs(TreeNode node, LinkedList<Integer> list, int middle, int sum) {
        if (node.left == null && node.right == null) {
            if ((middle + node.val) == sum) {
                // Deep copy
                list.addLast(node.val);
                ans.add(new ArrayList<>(list));
                list.removeLast();
            }
            return;
        }

        list.addLast(node.val);
        if (node.left != null) {
            dfs(node.left, list, middle + node.val, sum);
        }
        if (node.right != null) {
            dfs(node.right, list, middle + node.val, sum);
        }

        list.removeLast();
    }
}
