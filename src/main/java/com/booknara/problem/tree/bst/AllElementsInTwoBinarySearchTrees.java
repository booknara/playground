package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. All Elements in Two Binary Search Trees (Medium)
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {
    // T:O(n, the number of total tree elements(root1, root2), S:O(n)
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }

        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
