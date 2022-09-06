package com.coding.exercises.lists;

import com.coding.exercises.utils.ListNode;

public class AddTwoNumberList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        ListNode prevNode = null;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            //System.out.println("Common Sum : " + sum + " Carry: " + carry);
            ListNode newNode = new ListNode(sum);
            newNode.next = prevNode;
            prevNode = newNode;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum/10;
            sum = sum%10;
            //System.out.println("L1 Sum : " + sum + " Carry: " + carry);
            ListNode newNode = new ListNode(sum);
            newNode.next = prevNode;
            prevNode = newNode;
            
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            //System.out.println("L2 Sum : " + sum + " Carry: " + carry);
            ListNode newNode = new ListNode(sum);
            newNode.next = prevNode;
            prevNode = newNode;
            
            l2 = l2.next;
        }
        
        if (carry != 0) {
            //System.out.println(" Carry: " + carry);
            ListNode newNode = new ListNode(carry);
            newNode.next = prevNode;
            prevNode = newNode;
        }

        return reverse(prevNode);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while(head != null) {
            // System.out.println("Head Data: " + head.val);
            next = head.next;
            head.next = prev;
            prev = head;
            head = next; 
        }
        return  prev;
    }
}
