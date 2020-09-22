package com.booknara.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1522. Diameter of N-Ary Tree (Medium)
 * https://leetcode.com/problems/diameter-of-n-ary-tree/
 */
public class DiameterOfNAryTree {
    int totalMax = 0;

    // T:O(n), S:O(h). n = skewed tree
    public int diameter(Node root) {
        // input check
        if (root == null) return totalMax;

        helper(root);
        return totalMax;
    }

    public int helper(Node node) {
        // base case
        if (node == null) return 0;

        int preMax = 0;
        int max = 0;
        for (Node n : node.children) {
            int temp = helper(n);
            if (temp > max) {
                preMax = max;   // Note
                max = temp;
            } else if (temp > preMax) {
                preMax = temp;
            }
        }

        // two nodes
        totalMax = Math.max(totalMax, preMax + max);

        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
