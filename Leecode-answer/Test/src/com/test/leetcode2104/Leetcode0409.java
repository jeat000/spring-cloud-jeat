package com.test.leetcode2104;

import java.util.Arrays;

/**
 * @ClassName Leetcode0409
 * @Author chenjian
 * @Date 2021-04-12 12:58
 */
public class Leetcode0409 {
    public int findMin(int[] nums) {
        /*int n=nums.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]==nums[r]){
                r--;
            }else if(nums[mid]<nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];*/
        Arrays.sort(nums);
        return nums[0];
    }
}
