package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II (Medium)
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {
    // T:O(max(n, m) + 1), S:O(max(n, m))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // input check, non-empty linked list

        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        int carry = 0;
        while (reverse1 != null || reverse2 != null || carry == 1) {
            int num1 = 0, num2 = 0;
            if (reverse1 != null) {
                num1 = reverse1.val;
                reverse1 = reverse1.next;
            }

            if (reverse2 != null) {
                num2 = reverse2.val;
                reverse2 = reverse2.next;
            }

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        return reverse(head.next);
    }

    public ListNode reverse(ListNode node) {
        // reverse node. e.g. 1->2->3 => 3->2->1
        ListNode head = new ListNode(0);
        head.next = node;
        while (node.next != null) {
            ListNode temp = node.next;
            node.next = temp.next;
            temp.next = head.next;
            head.next = temp;
        }

        return head.next;
    }

    // T:O(max(n, m) + 1), S:O(max(n + m))
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // input check, non-empty linked list

        ListNode head = new ListNode(0);

        int carry = 0;
        Stack<ListNode> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int num1 = 0, num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop().val;
            }

            if (!stack2.isEmpty()) {
                num2 = stack2.pop().val;
            }

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode list = new ListNode(sum);
            list.next = head.next;
            head.next = list;
        }

        return head.next;
    }
}
/**

 5 -> 6 -> 4
 6 -> 5 -> 4
 4 -> 6 -> 5

 [7,2,4,3]
   [5,6,4]
 [7,8,0,7] -> [7,0,8,7]
 */