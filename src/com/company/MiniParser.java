package com.company;

import java.util.Stack;

/**
 * Created by hongruzh on 10/25/16.
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }

        NestedInteger result = new NestedInteger();

        Stack<NestedInteger> stack = new Stack<NestedInteger>();

        if (s.charAt(0) != '[') {
            int num = Integer.parseInt(s);
            return new NestedInteger(num);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                continue;
            }
            if (s.charAt(i) == '[') {
                if (stack.isEmpty()) {
                    stack.push(new NestedInteger());
                } else {
                    NestedInteger temp = new NestedInteger();
                    stack.peek().add(temp);
                    stack.push(temp);
                }
            } else if (s.charAt(i) == ']') {
                result = stack.pop();
            } else {
                StringBuilder sb = new StringBuilder();
                int j = i;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) != '-' && !Character.isDigit(s.charAt(j))) {
                        break;
                    }
                    sb.append(s.charAt(j));
                }
                int num = Integer.parseInt(sb.toString());
                stack.peek().add(new NestedInteger(num));
                i = j - 1;
            }
        }


        return result;
    }
}



