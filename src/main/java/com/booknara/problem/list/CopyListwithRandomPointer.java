package com.booknara.problem.list;

import com.booknara.problem.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet code : 138. Copy List with Random Pointer(Medium)
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 * or null if it does not point to any node.
 */
public class CopyListwithRandomPointer {
    // Key: old node, Value: new node
    Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.next = getNode(oldNode.next);
            newNode.random = getNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visited.get(head);
    }

    private Node getNode(Node node) {
        if (node == null) {
            return null;
        }

        if (!visited.containsKey(node)) {
            visited.put(node, new Node(node.val));
        }

        return visited.get(node);
    }
}
