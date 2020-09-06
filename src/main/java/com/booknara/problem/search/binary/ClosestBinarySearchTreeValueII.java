package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

import java.util.*;

/**
 * 272. Closest Binary Search Tree Value II (Hard)
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 */
public class ClosestBinarySearchTreeValueII {
    // T:O(n), S:O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        // max heap
        Deque<Integer> dq = new ArrayDeque<>();
        inorder(root, dq);

        while (dq.size() > k) {
            if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target)) {
                dq.pollFirst();
            } else {
                dq.pollLast();
            }
        }

        res.addAll(dq);
        return res;
    }

    public void inorder(TreeNode node, Deque<Integer> dq) {
        if (node == null) return;

        inorder(node.left, dq);
        dq.offer(node.val);
        inorder(node.right, dq);
    }

    // T:O(n*logk), S:O(k + n)
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            double diff1 = Math.abs(target - (double)i1);
            double diff2 = Math.abs(target - (double)i2);

            return Double.compare(diff2, diff1);
        });

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                pq.offer(node.val);
                if (pq.size() > k) pq.poll();

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        res.addAll(pq);

        return res;
    }
}
