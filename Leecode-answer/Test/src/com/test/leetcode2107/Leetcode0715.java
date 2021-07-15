package com.test.leetcode2107;

import java.util.Arrays;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0715
 * @Author chenjian
 * @Date 2021-07-15 12:41
 */
public class Leetcode0715 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0]=1;
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]+1){
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }
}
