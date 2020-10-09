package com.booknara.problem.tree;

/**
 * 1612. Check If Two Expression Trees are Equivalent (Medium)
 * https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/
 */
public class CheckIfTwoExpressionTreesAreEquivalent {
    // T:O(n), S:O(1, only lowercase contained)
    public boolean checkEquivalence(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        int[] bucket = new int[26];

        traverse(root1, bucket, 1);
        traverse(root2, bucket, -1);

        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) return false;
        }

        return true;
    }

    public void traverse(Node node, int[] bucket, int value) {
        if (node == null) return;

        traverse(node.left, bucket, value);
        if (node.val >= 'a' && node.val <= 'z') {
            bucket[node.val - 'a'] += value;
        }
        traverse(node.right, bucket, value);
    }

    static class Node {
        char val;
        Node left;
        Node right;
        Node() {this.val = ' ';}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}