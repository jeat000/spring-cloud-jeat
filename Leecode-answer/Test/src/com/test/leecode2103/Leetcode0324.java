package com.test.leecode2103;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Leetcode0324
 * @Author chenjian
 * @Date 2021-03-25 14:38
 */
public class Leetcode0324 {
    public boolean find132pattern(int[] nums) {
        int temp = Integer.MIN_VALUE;
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            if(nums[i]<temp){
                return true;
            }
            while(!stack.isEmpty() && stack.peek()<nums[i]){
                temp=stack.pop();
            }
            if(nums[i]>temp){
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
