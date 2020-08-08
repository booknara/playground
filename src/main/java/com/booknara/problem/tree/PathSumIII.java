package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III (Medium)
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    int res = 0;
    // T:O(n), S:O(n)
    public int pathSum1(TreeNode root, int sum) {
        // input check
        if (root == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        preorder(root, 0, sum, map);

        return res;
    }

    public void preorder(TreeNode node, int currSum, int sum, Map<Integer, Integer> map) {
        if (node == null) return;

        currSum += node.val;
        if (currSum == sum) res++;
        
        res += map.getOrDefault(currSum - sum, 0);
        int count = map.getOrDefault(currSum, 0);
        map.put(currSum, count + 1);

        if (node.left != null) {
            preorder(node.left, currSum, sum, map);
        }

        if (node.right != null) {
            preorder(node.right, currSum, sum, map);
        }

        map.put(currSum, map.get(currSum) - 1);
    }

}
