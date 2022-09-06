package com.coding.exercises.lists;

import com.coding.exercises.utils.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // special case for odd length list.
        if (fast != null) {
            slow = slow.next;
        }

        // reverse the slow -> end list
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow =  slow.next;
            fast = fast.next;
        }
        
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
