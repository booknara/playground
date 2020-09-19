package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 234. Palindrome Linked List (Easy)
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the first second half node using slow/fast pointer
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even length list, e.g. 1->2->3->2->1
        if (fast.next != null) {
            slow = slow.next;
        }

        // Reverse second half node
        slow = reverse(slow);

        // compare only half
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }

            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverse(ListNode node) {
        ListNode curHead = node;
        while (node.next != null) {
            ListNode p = node.next;
            node.next = p.next;
            p.next = curHead;
            curHead = p;
        }

        return curHead;
    }

    /**

     1->2->3->4
     .  t

     1->2->2->1
     s     s
     f     f
     if (f.next != null) move one more

     1->2->2->1
     1->2
     1->2->1
     1->2
     s  s
     f     f

     */

    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return isPalindrome(list);
    }

    public boolean isPalindrome(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    // T:O(n), S:O(n)
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        Deque<Integer> dq = new ArrayDeque<>();
        while (head != null) {
            dq.offerLast(head.val);
            head = head.next;
        }

        while (dq.size() >= 2) {
            int first = dq.pollFirst();
            int last = dq.pollLast();
            if (first != last) return false;
        }

        return true;
    }

}
