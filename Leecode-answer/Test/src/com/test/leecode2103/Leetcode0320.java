package com.test.leecode2103;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Leetcode0325
 * @Author chenjian
 * @Date 2021-03-25 14:37
 */
public class Leetcode0320 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s: tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int a=stack.pop();
                    stack.push(stack.pop()-a);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int b=stack.pop();
                    stack.push(stack.pop()/b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
