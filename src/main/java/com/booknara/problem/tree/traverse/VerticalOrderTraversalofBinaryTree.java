package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree (Medium)
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrderTraversalofBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // Key: x, PriorityQueue(min heap - y and then val)
        Map<Integer, PriorityQueue<NodeInfo>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        for (Map.Entry<Integer, PriorityQueue<NodeInfo>> entry: map.entrySet()) {
            List<Integer> levels = new ArrayList<>();
            PriorityQueue<NodeInfo> pq = entry.getValue();
            while(!pq.isEmpty()) {
                levels.add(pq.poll().val);
            }

            res.add(levels);
        }

        return res;
    }

    private void dfs(TreeNode node, int x, int y, Map<Integer, PriorityQueue<NodeInfo>> map) {
        if (node == null) {
            return;
        }

        PriorityQueue<NodeInfo> pq = map.getOrDefault(x, new PriorityQueue<>((node1, node2) -> {
            if (node1.y == node2.y) {
                return node1.val - node2.val;
            }

            return node1.y - node2.y;
        }));
        pq.add(new NodeInfo(x, y, node.val));
        map.put(x, pq);

        dfs(node.left, x - 1, y + 1, map);
        dfs(node.right, x + 1, y + 1, map);
    }

    class NodeInfo {
        int x;
        int y;
        int val;
        NodeInfo(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
