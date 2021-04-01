package com.test.leetcode2104;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Leetcode0401
 * @Author chenjian
 * @Date 2021-04-01 13:54
 */
public class Leetcode0401 {
    public int clumsy(int N) {
        int target=N;
        int res=0,index=0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(target);
        target--;
        while(target>0){
            if(index==0){
                stack.push(stack.pop()*target);
            }else if(index==1){
                stack.push(stack.pop()/target);
            }else if(index==2){
                stack.push(target);
            }else{
                stack.push(-target);
            }
            target--;
            index=(index+1)%4;
        }

        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
