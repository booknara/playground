package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 141. Linked List Cycle (Easy)
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  // T:O(n), S:O(1)
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }

      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }
}
