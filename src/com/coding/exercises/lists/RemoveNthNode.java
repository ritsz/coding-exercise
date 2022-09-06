package com.coding.exercises.lists;

import com.coding.exercises.utils.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        while(n != 0 && fast != null) {
            fast = fast.next;
            n -= 1;
        }
        
        if (n != 0) {
            System.out.println("List doesn't have enough elements");
            return slow;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            System.out.println("Slow : " + slow.val);
            System.out.println("Fast : " + fast.val);
        }

        return slow;
        
    }
}
