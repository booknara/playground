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

    // T:O(n), S:O(h)
    public List<List<Integer>> verticalOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // from top to bottom (bfs)
        int min = 0;
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(0, root));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Element e = q.poll();
                min = Math.min(min, e.col);
                List<Integer> list = map.getOrDefault(e.col, new ArrayList<>());
                list.add(e.node.val);
                map.put(e.col, list);

                if (e.node.left != null) {
                    q.offer(new Element(e.col - 1, e.node.left));
                }
                if (e.node.right != null) {
                    q.offer(new Element(e.col + 1, e.node.right));
                }
            }
        }

        while (map.containsKey(min)) {
            res.add(map.get(min));
            min++;
        }

        return res;
    }

    static class Element {
        int col;
        TreeNode node;
        Element (int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }
}
/**
 Level order traverse
 left move -1
 right move +1
 Map<Integer, List<Integer>> map = new HashMap<>();

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7

 -2 -> [4]
 -1 -> [9]
 0 -> [3,0,1]
 1 -> [8]
 2 -> [7]

 */