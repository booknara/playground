package com.booknara.problem.list;

import com.booknara.problem.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer (Medium)
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListwithRandomPointer {
    // T:O(n), S:O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        // Key: old node, Value: new node
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            //System.out.println(cur.val);
            Node n = getNode(map, cur);
            n.next = getNode(map, cur.next);
            n.random = getNode(map, cur.random);

            cur = cur.next;
        }

        return map.get(head);
    }

    private Node getNode(Map<Node, Node> map, Node node) {
        if (node == null) {
            return null;
        }

        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }

        return map.get(node);
    }
}
