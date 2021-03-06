package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 95. Unique Binary Search Trees II (Medium)
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
    // T:O(n*Gn), S:O(n*Gn), n*Gn=4^n/n^1/2, Gn=Catalan nunber
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        Map<Pair, List<TreeNode>> map = new HashMap<>();
        return dfs(1, n, map);
    }

    public List<TreeNode> dfs(int lower, int higher, Map<Pair, List<TreeNode>> map) {
        List<TreeNode> list = new ArrayList<>();
        if (lower > higher) {
            // should return list containing null;
            list.add(null);
            return list;
        }

        Pair p = new Pair(lower, higher);
        if (map.containsKey(p)) {
            return map.get(p);
        }

        // i (root)
        for (int i = lower; i <= higher; i++) {
            List<TreeNode> left = dfs(lower, i - 1, map);
            List<TreeNode> right = dfs(i + 1, higher, map);
            // left * right cases
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    list.add(n);
                }
            }
        }

        map.put(p, list);

        return list;
    }

    static class Pair {
        int lower;
        int higher;
        Pair(int lower, int higher) {
            this.lower = lower;
            this.higher = higher;
        }
    }

}
