package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists (Easy)
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionTwoLinkedLists {
    // Without space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0, lenB = 0;
        while (a != null) {
            lenA++;
            a = a.next;
        }

        while (b != null) {
            lenB++;
            b = b.next;
        }

        a = headA;
        b = headB;
        // Adjust two list lengths
        while (lenA > lenB) {
            lenA--;
            a = a.next;
        }
        while (lenA < lenB) {
            lenB--;
            b = b.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    // With space
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }

            set.add(headB);
            headB = headB.next;
        }

        return null;
    }
}
