package com.coding.exercises.lists;

import com.coding.exercises.utils.ListNode;

public class MaximumTwinSum {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        int maxSum = 0;
        while (slow != null) {
            if (slow.val + fast.val >= maxSum) maxSum = slow.val + fast.val;
            slow = slow.next;
            fast = fast.next;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
