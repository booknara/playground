package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees (Medium)
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {
    // T:O(n), S:(n)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;

        Map<String, Integer> map = new HashMap<>();
        inorder(root, map, res);

        return res;
    }

    public String inorder(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return "x";
        }

        String left = inorder(node.left, map, res);
        String right = inorder(node.right, map, res);

        String val = node.val + "," + left + "," + right;
        int count = map.getOrDefault(val, 0);
        if (count == 1) {
            res.add(node);
        }
        map.put(val, count + 1);

        return val;
    }
}
