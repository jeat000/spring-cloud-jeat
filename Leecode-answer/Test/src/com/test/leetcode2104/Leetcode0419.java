package com.test.leetcode2104;

/**
 * @ClassName Leetcode0419
 * @Author chenjian
 * @Date 2021-04-20 12:54
 */
public class Leetcode0419 {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            if(nums[l]==val){
                nums[l]=nums[r];
                r--;
            }else{
                l++;
            }
        }
        return l;
    }
}
