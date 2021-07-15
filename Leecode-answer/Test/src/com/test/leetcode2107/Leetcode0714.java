package com.test.leetcode2107;

import java.util.Arrays;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0714
 * @Author chenjian
 * @Date 2021-07-15 12:41
 */
public class Leetcode0714 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        int n = nums1.length;
        int[]rec = new int[n];
        rec = nums1.clone();
        Arrays.sort(rec);
        int sum=0,max = 0;

        for(int i=0; i<n; i++){
            if(nums1[i] == nums2[i]) continue;
            int temp = Math.abs(nums1[i]-nums2[i]);
            sum = (sum+temp)%MOD;
            int l = check(rec,nums2[i]);
            if(l<n) max = Math.max(max,temp-(rec[l]-nums2[i]));
            if(l>0) max = Math.max(max,temp-(nums2[i]-rec[l-1]));
        }
        return (sum-max+MOD)%MOD;
    }

    private int check(int[]rec, int s){
        int l=0,r=rec.length-1;
        if (rec[r] < s) {
            return r + 1;
        }
        while(l<r){
            int mid = l+(r-l)/2;
            if(s <= rec[mid]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
