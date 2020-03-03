package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans;

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
}
