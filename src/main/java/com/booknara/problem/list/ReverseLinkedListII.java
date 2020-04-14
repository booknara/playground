package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;
import com.booknara.problem.common.Pair;

/**
 * 92. Reverse Linked List II (Medium)
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode preM = null, nodeM = null, nodeN = null, nextN = null;
        int c = 1;
        while (cur != null) {
            if (c == m) {
                preM = pre;
                nodeM = cur;
            } else if (c == n) {
                // Disconnect next of n node
                nodeN = cur;
                nextN = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
            c++;
        }

        Pair<ListNode, ListNode> pair = reverse(nodeM, nodeN);
        ListNode pKey = pair.getKey();
        ListNode pValue = pair.getValue();
        // preM -> n
        preM.next = pKey;
        pValue.next = nextN;

        return res.next;
    }

    private Pair<ListNode, ListNode> reverse(ListNode start, ListNode end) {
        end.next = null;
        ListNode dummy = new ListNode(0);
        dummy.next = start;
        while (start.next != null) {
            ListNode p = start.next;
            start.next = start.next.next;
            p.next = dummy.next;
            dummy.next = p;
        }

        return new Pair(dummy.next, start);
    }

}
