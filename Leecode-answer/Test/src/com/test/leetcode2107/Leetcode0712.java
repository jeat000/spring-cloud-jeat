package com.test.leetcode2107;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0712
 * @Author chenjian
 * @Date 2021-07-15 12:40
 */
public class Leetcode0712 {
    public int hIndex(int[] citations) {
        int res=0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i]>res){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}
