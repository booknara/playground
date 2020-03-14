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
    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        map = new HashMap<>();
        dfs(root);

        return res;
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(node.val);
        builder.append(",");
        builder.append(dfs(node.left));
        builder.append(",");
        builder.append(dfs(node.right));
        String serial = builder.toString();
        //System.out.println(serial);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            res.add(node);
        }

        return serial;
    }
}
