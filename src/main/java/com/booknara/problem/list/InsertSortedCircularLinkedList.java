package com.booknara.problem.list;

import com.booknara.problem.common.Node;

/**
 * 708. Insert into a Sorted Circular Linked List (Medium)
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 */
public class InsertSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node cur = head;
        boolean init = true;
        boolean found = false;
        while (cur != head || init) {
            // System.out.println(pre.val);
            // System.out.println(cur.val);
            // ascending or new start
            if (!init && pre.val <= insertVal && insertVal <= cur.val) {
                add(pre, cur, insertVal);
                found = true;
                break;
            } else if (pre.val > cur.val &&
                    (insertVal < cur.val || insertVal > pre.val)) {
                add(pre, cur, insertVal);
                found = true;
                break;
            }

            pre = cur;
            cur = cur.next;
            init = false;
        }

        if (!found) {
            // insert it next to prev
            add(pre, cur, insertVal);
        }

        return head;
    }

    public void add(Node pre, Node cur, int val) {
        Node node = new Node(val);
        node.next = cur;
        pre.next = node;
    }
}
