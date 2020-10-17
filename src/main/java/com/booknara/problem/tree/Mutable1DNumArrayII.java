package com.booknara.problem.tree;

/**
 * 307. Range Sum Query - Mutable (Medium)
 * https://leetcode.com/problems/range-sum-query-mutable/
 */
public class Mutable1DNumArrayII {
    SegmentTreeNode root;
    public Mutable1DNumArrayII(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode tree = new SegmentTreeNode(start, end);
        if (start == end) {
            tree.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            tree.left = buildTree(nums, start, mid);
            tree.right = buildTree(nums, mid + 1, end);
            tree.sum = tree.left.sum + tree.right.sum;
        }

        return tree;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode node, int i, int val) {
        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (i <= mid) {
                update(node.left, i, val);
            } else {
                update(node.right, i, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (end <= mid) {
            return sumRange(node.left, start, end);
        } else if (start >= mid + 1) {
            return sumRange(node.right, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
}
