package com.test.leetcode2105;

/**
 * @ClassName Leetcode0527
 * @Author chenjian
 * @Date 2021-05-27 12:35
 */
public class Leetcode0527 {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int sum=0;
        while(z!=0){
            sum+=z&1;
            z=z>>1;
        }
        return sum;
    }
}
