package com.test.leetcode2104;

/**
 * @ClassName Leetcode0430
 * @Author chenjian
 * @Date 2021-05-06 10:25
 */
public class Leetcode0430 {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i=0;i<32;i++){
            int s = 0;
            for(int num:nums){
                s+=(num>>i)&1;
            }
            if (s % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
