package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class BinaryTreeVerticalOrderTraversal {
    // T:O(n), S:O(h)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        queue.add(root);
        numbers.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer num = numbers.poll();

            List<Integer> values = map.getOrDefault(num, new ArrayList<>());
            values.add(node.val);
            map.put(num, values);

            if (node.left != null) {
                queue.add(node.left);
                numbers.add(num - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                numbers.add(num + 1);
            }
        }

        res.addAll(map.values());

        return res;
    }
}
