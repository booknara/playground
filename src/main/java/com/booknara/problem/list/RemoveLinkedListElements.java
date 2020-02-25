package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode prev = ans;
        while (head != null) {
            //System.out.println(current.val);
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }

            head = head.next;
        }

        return ans.next;
    }
}
