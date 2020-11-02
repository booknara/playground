package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 1290. Convert Binary Number in a Linked List to Integer (Easy)
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    // T:O(n), S:O(1)
    public int getDecimalValue(ListNode head) {
        // input check, head is not empty
        int pow = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            pow++;
        }

        // subtract 1 because of the last null
        pow--;
        //System.out.println(pow);

        int res = 0;
        cur = head;
        while (cur != null) {
            res += Math.pow(2, pow) * cur.val;
            cur = cur.next;
            pow--;
        }

        return res;
    }
}
