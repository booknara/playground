package com.booknara.problem.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph (Medium)
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    // T:O(v+e), S:O(v)
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);
        ArrayList<Node> list = new ArrayList<>();
        for (Node n: node.neighbors) {
            list.add(cloneGraph(n));
        }
        clone.neighbors = list;


        return clone;
    }

    public Node cloneGraph1(Node node) {
        // input check
        if (node == null) return null;

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node n: node.neighbors) {
            Node temp;
            if (map.containsKey(n)) {
                temp = map.get(n);
            } else {
                temp = cloneGraph(n);
            }

            newNode.neighbors.add(temp);
        }

        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
