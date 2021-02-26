package com.test.demo;

import java.util.*;

public class Test_1221 {

    public static void main(String[] args) {
        /*int[] nums = new int[]{5,7,7,8,8,8};
        int [] s = searchRange(nums, 8);
        System.out.println(s[0]);
        System.out.println(s[1]);*/

        /*String s="pwwkew";
        int n = s.length();
        int max=0;
        Set<Character> set = new HashSet<>();
        int left=0,right=0;
        while(left<=right && right<n){
            if(set.add(s.charAt(right))){
                right++;
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println(max);*/

        String s= "loveleetcode";
        int[] strs = new int[26];
        for(char c: s.toCharArray()){
            strs[c-'a']++;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0; i<26;i++){
            if(strs[i]==1){
                res = Math.min(res,s.lastIndexOf((char)(i+'a')));
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftNode = check(true,nums,target);
        int rightNode = check(false,nums,target);
        if(leftNode<=rightNode && rightNode<nums.length && nums[leftNode]==target && nums[rightNode]==target){
            return new int[]{leftNode,rightNode};
        }
        return new int[]{-1,-1};
    }

    private static int check(boolean isLeft, int[]nums, int target){
        int left = 0,right=nums.length-1,res=nums.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right=mid-1;
            }else if(nums[mid] < target){
                left=mid+1;
            }else{
                if(isLeft){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            if(isLeft){
                res = left;
            }else{
                res = right;
            }
        }
        return res;
    }
}
