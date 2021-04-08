package com.test.leetcode2104;

/**
 * @ClassName Leetcode0408
 * @Author chenjian
 * @Date 2021-04-08 17:00
 */
public class Leetcode0408 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
