package com.coding.exercises.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // Insert in minStack if a new minimum is found
        // (lesser or equal to old minimum).
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer val = stack.pop();
        System.out.println("Remove Stack: " + val);
        Integer val2 = minStack.peek();
        System.out.println("Min Stack Top: " + val2);

        // If the stack->top and minStack->top are same,
        // remove from minStack as well.
        if (val.equals(val2)) {
            Integer val3 = minStack.pop();
            System.out.println("Remove Minimum Stack: " + val3);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
