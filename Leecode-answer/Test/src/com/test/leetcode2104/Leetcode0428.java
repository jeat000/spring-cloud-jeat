package com.test.leetcode2104;

/**
 * @ClassName Leetcode0428
 * @Author chenjian
 * @Date 2021-05-06 10:24
 */
public class Leetcode0428 {
    public boolean judgeSquareSum(int c) {
        for(long i=0;i*i<=c;i++){
            double s = Math.sqrt(c-i*i);
            if(s==(int)s){
                return true;
            }
        }
        return false;
    }
}
