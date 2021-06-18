package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0615
 * @Author chenjian
 * @Date 2021-06-15 12:48
 */
public class Leetcode0615 {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }else if(arr[mid]>arr[mid+1]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
