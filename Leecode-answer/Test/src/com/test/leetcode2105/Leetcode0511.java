package com.test.leetcode2105;

import java.util.Arrays;

/**
 * @ClassName Leetcode0511
 * @Author chenjian
 * @Date 2021-05-11 12:55
 */
public class Leetcode0511 {

    public static void main(String[] args) {
        int[]s=new int[]{3,12,1,15,5,2,3,7};
        System.out.println(Arrays.toString(decode(s)));
    }

    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[]res = new int[n];
        for(int i=1;i<n;i++){
            res[0]=i;
            for(int o=0;o<n-1;o++){
                res[o+1]=res[o]^encoded[o];
                if(res[o+1]>n || res[o+1]==0){
                    break;
                }
                if(o==n-2){
                    return res;
                }
            }
        }
        return res;
    }

    public int[] decode2(int[] encoded) {
        int n = encoded.length + 1;
        int total=0;
        for(int i=1;i<=n;i++){
            total^=i;
        }
        int other=0;
        for(int i=1;i<n-1;i=i+2){
            other^=encoded[i];
        }
        int[]res = new int[n];
        res[0]=total^other;
        for(int i=0;i<n-1;i++){
            res[i+1]=res[i]^encoded[i];
        }
        return res;
    }
}
