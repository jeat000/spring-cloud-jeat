package com.test.leetcode2104;

/**
 * @ClassName Leetcode0405
 * @Author chenjian
 * @Date 2021-04-06 10:13
 */
public class Leetcode0405 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1, temp=m+n-1;
        int cur=0;
        while(i>=0 || j>=0){
            if(i==-1){
                cur=nums2[j--];
            }else if(j==-1){
                cur=nums1[i--];
            }else if(nums1[i]>nums2[j]){
                cur=nums1[i--];
            }else{
                cur=nums2[j--];
            }
            nums1[temp--]=cur;
        }
    }
}
