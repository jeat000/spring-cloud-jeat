package com.test.leetcode2104;

import java.util.Arrays;

/**
 * @ClassName Leetcode0406
 * @Author chenjian
 * @Date 2021-04-06 10:13
 */
public class Leetcode0406 {
    public static void main(String[] args) {
        int[] res = new int[]{1,1,1,2,2,3};
        int i = removeDuplicates(res);
        System.out.println(i);
        System.out.println(Arrays.toString(res));
    }
    public static int removeDuplicates(int[] nums) {
        int left=0,right=1,n=nums.length,flag=0;
        if(n==0) return 0;
        if(n==1) return 1;
        while(right<n){
            if(nums[left]==nums[right] && flag==0){
                nums[left+1]=nums[right];
                flag++;
                left++;
            }else if(nums[left]!=nums[right]){
                nums[left+1]=nums[right];
                flag=0;
                left++;
            }
            right++;
        }
        return left+1;
    }
}
