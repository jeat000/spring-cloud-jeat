package com.test.leetcode2107;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0708
 * @Author chenjian
 * @Date 2021-07-09 12:49
 */
public class Leetcode0708 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l1=0,l2=0,r=0;
        int s1=0,s2=0,res=0;
        while(r<nums.length){
            s1+=nums[r];
            while (l1<=r && s1>goal){
                s1-=nums[l1++];
            }
            s2+=nums[r];
            while (l2<=r && s2>=goal){
                s2-=nums[l2++];
            }
            res += l2-l1;

            r++;
        }
        return res;
    }
}
