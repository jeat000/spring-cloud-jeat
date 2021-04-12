package com.test.leetcode2104;

/**
 * @ClassName Leetcode0407
 * @Author chenjian
 * @Date 2021-04-08 17:00
 */
public class Leetcode0407 {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==0) return false;
        if(n==1) return target == nums[0];
        int l=0,r=n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[l]==nums[mid] && nums[mid]==nums[r]){
                l++;
                r--;
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<=nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}