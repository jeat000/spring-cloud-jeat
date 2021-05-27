package com.test.leetcode2105;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Leetcode0526
 * @Author chenjian
 * @Date 2021-05-27 12:35
 */
public class Leetcode0526 {
    public String reverseParentheses(String s) {
        if(s.length()==0) return "";
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(i);
            }else if(arr[i]==')'){
                reverse(arr,stack.pop(),i);
            }
        }
        for(char c: arr){
            if(c!='(' && c!=')'){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void reverse(char[]arr, int l, int r){
        while(l<r){
            char temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}
