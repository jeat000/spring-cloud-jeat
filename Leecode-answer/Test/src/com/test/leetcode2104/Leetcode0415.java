package com.test.leetcode2104;

/**
 * @ClassName Leetcode0415
 * @Author chenjian
 * @Date 2021-04-20 12:55
 */
public class Leetcode0415 {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }else if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(getMax(nums,0,n-2),getMax(nums,1,n-1));
    }
    private int getMax(int[]nums,int start, int end){
        int first = nums[start],second=Math.max(first,nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int temp = second;
            second=Math.max(second,first+nums[i]);
            first=temp;
        }
        return second;
    }
}
