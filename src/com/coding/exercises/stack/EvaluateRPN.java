package com.coding.exercises.stack;

import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<>();
        for(String token: tokens) {
            if (token.equals("+")) {
                rpnStack.push(rpnStack.pop() + rpnStack.pop());
            } else if (token.equals("*")) {
                rpnStack.push(rpnStack.pop() * rpnStack.pop());
            } else if (token.equals("-")) {
                Integer two = rpnStack.pop();
                Integer one = rpnStack.pop();
                rpnStack.push(one - two);
            } else if (token.equals("/")) {
                Integer two = rpnStack.pop();
                Integer one = rpnStack.pop();
                rpnStack.push(one/two);
            } else {
                Integer i = Integer.valueOf(token);
                rpnStack.push(i);
            }
        }

        return rpnStack.pop();
    }
}
