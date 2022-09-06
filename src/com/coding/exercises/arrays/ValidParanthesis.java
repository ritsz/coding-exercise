package com.coding.exercises.arrays;

import java.util.Stack;
  

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        try {
            for(Character c : s.toCharArray()) {
                if ((c == '{' ) ||
                    (c == '[') ||
                    (c == '(')) {
                    stack.push(c);
                } else if (c == '}') {
                    Character x = stack.pop();
                    if (x != '{') return false;
                } else if (c == ']') {
                    Character x = stack.pop();
                    if (x != '[') return false;
                } else if (c == ')') {
                    Character x = stack.pop();
                    if (x != '(') return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return stack.empty();
    }
}
