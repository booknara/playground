package com.booknara.problem.list;

import com.booknara.problem.common.Node;

public class MySinglyLinkedList {
    private static final int FIRST_INDEX = 0;
    Node head;
    int size;

    /** Initialize your data structure here. */
    public MySinglyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size == 0 || size - 1 < index) {
            return -1;
        }

        int i = FIRST_INDEX;
        Node cur = head.next;
        while (cur != null) {
            if (i == index) {
                return cur.val;
            }

            cur = cur.next;
            i++;
        }

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = head.next;
        Node prev = head;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = new Node(val);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node cur = head.next;
        Node prev = head;
        int i = FIRST_INDEX;
        while (cur != null) {
            if (i == index) {
                break;
            }

            prev = cur;
            cur = cur.next;

            i++;
        }

        // prev, cur
        Node node = new Node(val);
        node.next = cur;
        prev.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || size - 1 < index) {
            return;
        }

        Node cur = head.next;
        Node prev = head;
        int i = FIRST_INDEX;
        while (cur.next != null) {
            if (i == index) {
                break;
            }

            prev = cur;
            cur = cur.next;

            i++;
        }

        // prev, cur
        prev.next = cur.next;
        size--;
    }
}
