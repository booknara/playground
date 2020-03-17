package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // Without Space
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                // head, s should be met because of this formular
                // 2 * (distance of s) = distance of f
                // Head to entrance: F
                // Entrance to Node met: A
                // Node met to entrance: B
                // 2(F + A) = F + 2A + B -> 2F = F + B -> F = B
                while (head != s) {
                    head = head.next;
                    s = s.next;
                }

                return head;
            }
        }

        return null;
    }

    // With Space
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }
}
