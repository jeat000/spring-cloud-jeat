package com.test.leetcode2107;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0704
 * @Author chenjian
 * @Date 2021-07-06 12:47
 */
public class Leetcode0704 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        boolean[] flag = new boolean[nums.length+1];
        for(int n:nums){
            if(flag[n]==false){
                flag[n]=true;
            }else{
                res[0]=n;
            }
        }
        for(int i=1;i<flag.length; i++){
            if(!flag[i]){
                res[1]=i;
            }
        }
        return res;
    }
}
